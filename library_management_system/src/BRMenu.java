import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BRMenu extends JFrame implements ActionListener {

    int flag=0;
    String name;
    static JButton jB1,jB2,jB3;

    public BRMenu(String name,int flag){
        super("借还书籍");
        this.name=name;
        this.flag=flag;

        jB1=new JButton("借阅书籍");
        jB1.setBounds(100, 50, 150, 30);
        jB1.addActionListener(this);

        jB2=new JButton("归还书籍");
        jB2.setBounds(100, 100, 150, 30);
        jB2.addActionListener(this);

        jB3=new JButton("返回");
        jB3.setBounds(100, 150, 150, 30);
        jB3.addActionListener(this);

        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);

        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(jB3);

        this.setBounds(300,400,500,320);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jB1){
            borrowBook w1=new borrowBook(name,flag);
            this.setVisible(false);
        }

        if(e.getSource()==jB2){
            returnBook w2=new returnBook(name,flag);
            this.setVisible(false);
        }

        if(e.getSource()==jB3){
            this.setVisible(false);
            if(flag==1){
                IndexActivity w3=new IndexActivity(name);
            }else{
                IndexActivity2 w4=new IndexActivity2(name);
            }
        }

    }

    public static void main(String[] args){
        BRMenu w=new BRMenu("test",1);
    }
}
