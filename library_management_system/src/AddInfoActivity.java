
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

public class AddInfoActivity extends JFrame implements ActionListener {
    static BookInfoMenu w2;
    JLabel jL1, jL2, jLname,jL3;
    JButton jB1, jB2;
    JTextField jF1, jF2,jF3;
    JMenuItem openMenuItem;
    JMenu fileMenu;
    JMenuBar mbar;// 定义菜单
    JFileChooser jFc;
    File file;
    FileReader fileread;
    BufferedReader bufread;
    String readStr = "";
    JScrollPane scrollPane;
    JTextArea textArea;
    static String user;
    int flag=0;
    public AddInfoActivity(String user,int flag) {

        super("图书信息管理程序_添加图书信息");
        this.flag=flag;
        this.user=user;
        jLname = new JLabel("用户名称: "+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);

        jL1 = new JLabel("添加的书名:");
        jL1.setFont(new Font("宋体", Font.BOLD, 20));
        jL1.setBounds(30, 60, 200, 30);

        jL2 = new JLabel("添加的简介:");
        jL2.setFont(new Font("宋体", Font.BOLD, 20));
        jL2.setBounds(30, 120, 200, 30);

        jL3=new JLabel("添加的数量:");
        jL3.setFont(new Font("宋体",Font.BOLD,20));
        jL3.setBounds(30,180,200,30);

        jF1 = new JTextField("", 20);
        jF1.setBounds(170, 60, 200, 30);

        jF2 = new JTextField("", 20);
        jF2.setBounds(170, 120, 200, 30);

        jF3=new JTextField("",20);
        jF3.setBounds(170,180,200,30);

        jB1 = new JButton("添加");
        jB1.setBounds(60, 250, 60, 30);
        jB1.addActionListener(this);

        jB2 = new JButton("返回");
        jB2.setBounds(250, 250, 60, 30);
        jB2.addActionListener(this);



        openMenuItem = new JMenuItem("导入");
        openMenuItem.addActionListener(this);
        fileMenu = new JMenu("文件");
        mbar = new JMenuBar();
        fileMenu.add(openMenuItem);
        mbar.add(fileMenu);

        textArea = new JTextArea();
        textArea.setLineWrap(true); // 自动换行
        textArea.setFont(new Font("sssssssss", Font.PLAIN, 18)); // 设置字体
        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(400, 50, 500, 400);
        this.setJMenuBar(mbar);
        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);

        winContainer.add(jLname);
        winContainer.add(jL1);
        winContainer.add(jL2);
        winContainer.add(jL3);

        winContainer.add(jF1);
        winContainer.add(jF2);
        winContainer.add(jF3);

        winContainer.add(jB1);
        winContainer.add(jB2);

        winContainer.add(scrollPane);
        this.setSize(1100, 500);
        this.setLocation(500, 500);
        this.setVisible(true);
        try {
            SQLTxt.searchAllTxtFile();
            textArea.setText(SQLTxt.getreadStr());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

        AddInfoActivity w3 = new AddInfoActivity(user,1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == jB1) {
            if (jF1.getText().toString() != null && jF1.getText().toString().length() > 0&&!jF3.getText().toString().equals("0") ){
                if (jF2.getText().toString() != null && jF2.getText().toString().length() > 0) {
                    Book book = new Book(jF1.getText().toString(), jF2.getText().toString(),Integer.parseInt(jF3.getText().toString()),0);
                    try {
                        SQLTxt.writeSQL(book.toString());
                        SQLTxt.searchAllTxtFile();
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "添加成功", "提示", 1);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(w2, "添加失败", "提示", 2);
                    }

                } else {
                    JOptionPane.showMessageDialog(w2, "简介不为空", "提示", 1);
                }
            } else {
                JOptionPane.showMessageDialog(w2, "书名不为空", "提示", 1);

            }

        } else if (e.getSource() == jB2) {
            this.setVisible(false);
            if(flag==1){
                w2 = new BookInfoMenu(user,1);
            }
        } else
            readStr = "";
        if (e.getSource() == openMenuItem) {
            int returnVal = jFc.showOpenDialog(this);
            if (returnVal == 0) {
                file = jFc.getSelectedFile();
                try {
                    SQLTxt.readTxtFile(file.getPath());
                    //System.out.println(SQLTxt.getreadStr());

                    try {
                        SQLTxt.writeTxtFile(SQLTxt.getreadStr());
                        SQLTxt.searchAllTxtFile();
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "添加成功", "提示", 1);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            } else {
                //JOptionPane.showMessageDialog(w2, "你没有选择文件", "提示", 1);
            }

        }
    }

}

