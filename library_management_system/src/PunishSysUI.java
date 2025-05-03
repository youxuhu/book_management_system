import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PunishSysUI extends JFrame implements ActionListener {

    static IndexActivity w2;

    JButton jB1,jB2;
    JTextField jF1;
    JTextArea textArea;
    JScrollPane scrollPane;

    int flag=0;
    String user;

    public PunishSysUI(String user,int flag){
        super("借阅未归还惩罚名单");

        this.user=user;
        this.flag=flag;

        jB1=new JButton("查询");
        jB1.setBounds(20,50,60,30);
        jB1.addActionListener(this);

        jF1=new JTextField("",20);
        jF1.setBounds(100,50,100,30);

        jB2=new JButton("返回");
        jB2.setBounds(60,200,60,30);
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

        winContainer.add(jF1);
        winContainer.add(jF1);
        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(scrollPane);
        this.setSize(1100, 280);
        this.setLocation(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        jF1.requestFocus();
        PunishSysSQL.Punishcount();
        textArea.setText(PunishSysSQL.returnString());

    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jB1){
            if(jF1.getText().toString()==null){
                JOptionPane.showMessageDialog(w2, "查询内容不得为空", "提示", 1);
            } else{
                PunishSysSQL.PunishInfoSearch(jF1.getText().toString());
                System.out.println(PunishSysSQL.returnString1());
                textArea.setText(PunishSysSQL.returnString1());
            }
        }
        if(e.getSource()==jB2){
            this.setVisible(false);
            if(flag==1){
                IndexActivity w1=new IndexActivity(user);
            }else{
                IndexActivity2 w2=new IndexActivity2(user);
            }
        }
    }

    public static void main(String[] args){
        PunishSysUI w=new PunishSysUI("test",1);
    }
}
