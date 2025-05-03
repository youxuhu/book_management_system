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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ReviseInfoActivity extends JFrame implements ActionListener {
    static BookInfoMenu w2;
    JLabel jL1, jL2, jL3, jLname;
    JButton jB1, jB2;
    JTextField jF1, jF2, jF3, jF4, jF,jF5,jF6;
    JScrollPane scrollPane;
    JTextArea textArea;
    String user;


    public ReviseInfoActivity(String user) {
        super("图书信息管理程序_修改图书信息");
        this.user=user;
        jLname = new JLabel("用户名称: "+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);

        jL1 = new JLabel("修改前的信息:");
        jL1.setFont(new Font("宋体", Font.BOLD, 20));
        jL1.setBounds(20, 15, 200, 30);

        jL2 = new JLabel("修改后的信息:");
        jL2.setFont(new Font("宋体", Font.BOLD, 20));
        jL2.setBounds(20, 90, 200, 30);

        jF1 = new JTextField("", 20);
        jF1.setBounds(160, 15, 200, 30);

        jF2 = new JTextField("", 20);
        jF2.setBounds(160, 90, 200, 30);

        jF3 = new JTextField("", 20);
        jF3.setBounds(160, 50, 200, 30);

        jF4 = new JTextField("", 20);
        jF4.setBounds(160, 125, 200, 30);

        jF5=new JTextField("",20);
        jF5.setBounds(160,160,200,30);

        jF6=new JTextField("",20);
        jF6.setBounds(160,195,200,30);

        jF = new JTextField("", 20);

        jB1 = new JButton("修改");
        jB1.setBounds(60, 250, 60, 30);
        jB1.addActionListener(this);

        jB2 = new JButton("返回");
        jB2.setBounds(250, 250, 60, 30);

        jF1.addFocusListener(new JTextFieldHintListener(jF1, "书名"));
        jF2.addFocusListener(new JTextFieldHintListener(jF2, "书名"));
        jF3.addFocusListener(new JTextFieldHintListener(jF3, "简介"));
        jF4.addFocusListener(new JTextFieldHintListener(jF4, "简介"));
        jF5.addFocusListener(new JTextFieldHintListener(jF5,"数量"));
        jF6.addFocusListener(new JTextFieldHintListener(jF6,"借阅数量"));
        jB2.addActionListener(this);

        textArea = new JTextArea();
        textArea.setLineWrap(true); // 自动换行
        textArea.setFont(new Font("sssssssss", Font.PLAIN, 18)); // 设置字体


        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(400, 50, 660, 200);
        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);
        winContainer.add(jLname);
        winContainer.add(jL1);
        winContainer.add(jL2);
        winContainer.add(jF1);
        winContainer.add(jF2);
        winContainer.add(jF3);
        winContainer.add(jF4);
        winContainer.add(jF5);
        winContainer.add(jF6);
        winContainer.add(jF);
        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(scrollPane);
        this.setSize(1100, 400);
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
        ReviseInfoActivity w5 = new ReviseInfoActivity(t);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == jB1) {

            Book oldbook = new Book(jF1.getText().toString(), jF3.getText().toString());
            Book replacebook = new Book(jF2.getText().toString(), jF4.getText().toString(),Integer.parseInt(jF5.getText().toString()),Integer.parseInt(jF6.getText().toString()));
            SQLTxt.replaceTxtByStr(oldbook.Name(), replacebook.toString());//修改sqltxt的接口replaceTxtByStr()
            try {
                SQLTxt.searchAllTxtFile();
                textArea.setText(SQLTxt.getreadStr());
                JOptionPane.showMessageDialog(w2, "修改成功", "提示", 1);
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }



        }else if(e.getSource()==jB2){
            this.setVisible(false);
            w2 = new BookInfoMenu(user,1);
        }

    }

}


