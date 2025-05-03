import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SearchInfoActivity extends JFrame implements ActionListener {
    static IndexActivity w2;
    static IndexActivity2 wt;
    JLabel jL1, jL2, jLname;
    JButton jB1, jB2;
    JTextField jF1, jF;
    JScrollPane scrollPane;
    JTextArea textArea;
    String user;
    int flag;
    public SearchInfoActivity(String user,int flag) {
        super("图书信息管理程序_查询图书信息");
        this.user=user;
        this.flag=flag;

        jLname = new JLabel("用户名称: "+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);
        jL1 = new JLabel("信息:");
        jL1.setFont(new Font("宋体", Font.BOLD, 30));
        jL1.setBounds(20, 60, 200, 30);
        jF1 = new JTextField("", 20);
        jF1.setBounds(110, 60, 280, 30);
        jF1.setFont(new Font("宋体", Font.BOLD, 15));
        jF1.addFocusListener(new JTextFieldHintListener(jF1, "书名/简介(输入search.all查询全部)"));
        jF=new JTextField("", 20);
        jB1 = new JButton("查询");
        jB1.setBounds(60, 170, 60, 30);
        jB1.addActionListener(this);
        jB2 = new JButton("返回");
        jB2.setBounds(250, 170, 60, 30);
        jB2.addActionListener(this);
        // 创建文本区域组件
        textArea = new JTextArea();
        textArea.setLineWrap(true); // 自动换行
        textArea.setFont(new Font("sssssssss", Font.PLAIN, 18)); // 设置字体
        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(400, 50, 660, 160);
        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);
        winContainer.add(jLname);
        winContainer.add(jL1);
        winContainer.add(jF1);
        winContainer.add(jF);
        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(scrollPane);
        this.setSize(1100, 280);
        this.setLocation(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        jF.requestFocus();
        try {
            SQLTxt.searchAllTxtFile();
            textArea.setText(SQLTxt.getreadStr());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String t="";
        SearchInfoActivity w6 = new SearchInfoActivity(t,1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == jB1) {
            if (jF1.getText().toString() != null && jF1.getText().toString().length() > 0) {
                if (jF1.getText().toString().equals("search.all")) {
                    try {
                        SQLTxt.searchAllTxtFile();
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "查询成功", "提示", 1);
                        // System.out.println(SQLTxt.getreadStr());
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(w2, "查询失败", "提示", 1);
                        e1.printStackTrace();

                    }
                } else {
                    try {
                        SQLTxt.searchTxtFile(jF1.getText().toString());
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "查询成功", "提示", 1);
                        // System.out.println(SQLTxt.getreadStr());
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(w2, "查询失败", "提示", 1);
                        e1.printStackTrace();

                    }
                }
            } else {
                JOptionPane.showMessageDialog(w2, "输入不为空", "提示", 1);

            }

        } else if (e.getSource() == jB2) {
            this.setVisible(false);
            if(flag==1){
                w2 = new IndexActivity(user);
            }else{
                wt=new IndexActivity2(user);
            }
        }
    }

}

