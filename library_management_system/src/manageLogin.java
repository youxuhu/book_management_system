
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

public class manageLogin extends JFrame implements ActionListener{
    static manageLogin t;
    static IndexActivity w2;
    static JButton jB1,jB2,jB3;
    static JTextField jF1,jF2;
    static JLabel jL1,jL2,jLname;
    public manageLogin() {

        super("用户登录界面");

        jLname = new JLabel("用户登录界面");
        jLname.setFont(new Font("宋体", Font.BOLD, 20));
        jLname.setBounds(5, 5, 200, 30);

        jL1 = new JLabel("用户名");
        jL1.setFont(new Font("宋体", Font.BOLD, 20));
        jL1.setBounds(30, 60, 100, 30);

        jL2 = new JLabel("密码");
        jL2.setFont(new Font("宋体", Font.BOLD, 20));
        jL2.setBounds(30, 95, 100, 30);


        jB1 = new JButton("登录");//登录按钮
        jB1.setBounds(50, 150, 100, 40);
        jB1.addActionListener(this);

        jB2 = new JButton("注册");
        jB2.setBounds(50, 210, 100, 40);
        jB2.addActionListener(this);

        jB3=new JButton("返回");
        jB3.setBounds(50,270,100,40);
        jB3.addActionListener(this);

        jF1 = new JTextField("", 30);//用户名
        jF1.setBounds(140, 60, 150, 30);

        jF2 = new JTextField("", 30);//密码
        jF2.setBounds(140, 95, 150, 30);

        Container winContainer = this.getContentPane();

        winContainer.setLayout(null);

        winContainer.add(jLname);
        winContainer.add(jL1);
        winContainer.add(jL2);

        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(jB3);

        winContainer.add(jF1);
        winContainer.add(jF2);

        this.setSize(500, 400);
        this.setLocation(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception{
        manageLogin manageLogin1 =new manageLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int flag1;
        int flag2;
        if(e.getSource()==jB1){
            try {
                flag1= managerSQL.logIn(jF1.getText().toString(),jF2.getText().toString());
                if(flag1==1){
                    JOptionPane.showMessageDialog(t,"成功登录","提示",1);
                    IndexActivity w2 = new IndexActivity(jF1.getText().toString());
                    this.setVisible(false);
                }
                if(flag1==0){
                    JOptionPane.showMessageDialog(t,"用户名或密码错误","提示",1);
                }
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }

        }
        if(e.getSource()==jB2){
            try{
                flag2= managerSQL.register(jF1.getText().toString(),jF2.getText().toString());
                if(flag2==0){
                    JOptionPane.showMessageDialog(t,"用户名已经存在","",1);
                }
                if(flag2==1){
                    JOptionPane.showMessageDialog(t,"用户名密码不可为空","",1);
                }
                if(flag2==2){
                    JOptionPane.showMessageDialog(t,"注册成功","",1);
                }
            }catch(UnsupportedEncodingException ex1){
                throw new RuntimeException(ex1);
            }
        }

        if(e.getSource()==jB3){
            this.setVisible(false);
            MainActivity mianActivity=new MainActivity();
        }
    }

}
