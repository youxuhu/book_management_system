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

public class borrowBook extends JFrame implements ActionListener{

    int flag=0;
    JLabel jL1, jL2, jLname;
    JButton jB1, jB2 ;
    JTextField jF1, jF2;
    JScrollPane scrollPane;
    JTextArea textArea;
    static BRMenu w2;
    static BRMenu wt;
    static String user;

    public borrowBook(String user,int flag) {
        super("图书信息管理程序_借阅图书");
        this.user=user;
        this.flag=flag;
        jLname = new JLabel("用户名称:"+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);

        jL1 = new JLabel("借阅书名:");
        jL1.setFont(new Font("宋体", Font.BOLD, 20));
        jL1.setBounds(30, 60, 200, 30);

        jL2 = new JLabel("借阅数量:");
        jL2.setFont(new Font("宋体", Font.BOLD, 20));
        jL2.setBounds(30, 120, 200, 30);

        jF1 = new JTextField("", 20);//name
        jF1.setBounds(170, 60, 200, 30);

        jF2 = new JTextField("", 20);//count
        jF2.setBounds(170, 120, 200, 30);

        jB1 = new JButton("借阅");
        jB1.setBounds(60, 170, 60, 30);
        jB1.addActionListener(this);

        jB2 = new JButton("返回");
        jB2.setBounds(280, 170, 60, 30);
        jB2.addActionListener(this);


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
        winContainer.add(jL2);
        winContainer.add(jF1);
        winContainer.add(jF2);
        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(scrollPane);
        this.setSize(1100, 280);
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jB1){
            if(jF1.getText().toString()!=null){
                if(jF2.getText().toString()!=null&&Integer.parseInt(jF2.getText().toString())>0){
                    try {
                        SQLTxt.borBook(jF1.getText().toString(), Integer.parseInt(jF2.getText().toString()));
                        Borrow_n_Return_Book.BorrowBook(user,jF1.getText().toString(),Integer.parseInt(jF2.getText().toString()));

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        SQLTxt.searchAllTxtFile();
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "借阅成功！！！", "提示", 1);
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(w2, "数量不能为空且不能小于0！！！", "提示", 1);
                }
            }else{
                JOptionPane.showMessageDialog(w2, "书名不能为空！！！", "提示", 1);
            }
            jF1.setText("");
            jF2.setText("");

        }
        else if(e.getSource()==jB2){
            this.setVisible(false);
            if(flag==1){
                w2=new BRMenu(user,1);
            }else{
                wt=new BRMenu(user,0);
            }
        }
    }
    public static void main(String[] args){
        borrowBook w5=new borrowBook(user,1);
    }
}



