import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainActivity extends JFrame implements ActionListener{

    static JButton jB1,jB2,jB3;
    static JTextField jF1;
    static JLabel jLname,jL;

    public MainActivity(){
        super("图书管理系统——用户类别选择");

        jLname=new JLabel("欢迎使用图书管理系统");
        jLname.setFont(new Font("宋体", Font.BOLD, 50));
        jLname.setBounds(240, 100, 500, 100);

        jL=new JLabel("请选择您的身份");
        jL.setFont(new Font("宋体", Font.BOLD, 30));
        jL.setBounds(370, 250, 400, 100);

        jB1=new JButton("管理员");
        jB1.setFont(new Font("宋体",Font.BOLD,20));
        jB1.setBounds(320,400,150,50);
        jB1.addActionListener(this);


        jB2=new JButton("读者");
        jB2.setFont(new Font("宋体",Font.BOLD,20));
        jB2.setBounds(520,400,150,50);
        jB2.addActionListener(this);

        Container winContainer=this.getContentPane();
        winContainer.setLayout(null);
        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(jLname);
        winContainer.add(jL);

        this.setSize(1000, 700);
        this.setLocation(800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        MainActivity mainActivity=new MainActivity();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jB1){
            this.setVisible(false);manageLogin w1=new manageLogin();
        }
        if(e.getSource()==jB2){
            this.setVisible(false);
            ReaderLogin w2=new ReaderLogin();
        }
    }
}
