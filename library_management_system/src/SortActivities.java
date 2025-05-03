import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class SortActivities extends JFrame implements ActionListener{
    static JButton jB1,jB2,jB3;
    static String name;
    static int flag;

    public SortActivities(String name,int flag){
        super("排名子菜单");
        this.name=name;
        this.flag=flag;

        jB1=new JButton("书籍排名");
        jB1.setBounds(50,50,100,30);
        jB1.addActionListener(this);

        jB2=new JButton("读者排名");
        jB2.setBounds(50,100,100,30);
        jB2.addActionListener(this);

        jB3=new JButton("返回");
        jB3.setBounds(50,150,100,30);
        jB3.addActionListener(this);

        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);

        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(jB3);

        this.setBounds(200,300,500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jB1){
            BookSortUI w1=new BookSortUI(name,flag);
            this.setVisible(false);
        }
        if(e.getSource()==jB2){
            StuSortUI w2=new StuSortUI(name,flag);
            this.setVisible(false);
        }
        if(e.getSource()==jB3){
            if(flag==1){
                IndexActivity w3=new IndexActivity(name);
                this.setVisible(false);
            }
            else{
                IndexActivity2 w4=new IndexActivity2(name);
                this.setVisible(false);
            }
        }
    }

    public static void main(String[] args){
        SortActivities s=new SortActivities("test",1);
    }
}
