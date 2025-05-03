import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BookInfoMenu extends JFrame implements ActionListener{
    String name;
    int flag=0;
    static JButton jB1,jB2,jB3,jB4;

    public BookInfoMenu(String name,int flag)
    {
        super("书籍信息管理菜单");
        this.name=name;
        this.flag=flag;

        jB1=new JButton("增加书籍");
        jB1.setBounds(50, 50, 150, 30);
        jB1.addActionListener(this);

        jB2=new JButton("删除书籍");
        jB2.setBounds(50, 100, 150, 30);
        jB2.addActionListener(this);

        jB3=new JButton("修改书籍内容");
        jB3.setBounds(50,150, 150, 30);
        jB3.addActionListener(this);

        jB4=new JButton("返回");
        jB4.setBounds(50, 200, 150, 30);
        jB4.addActionListener(this);

        Container winContainer=getContentPane();
        winContainer.setLayout(null);

        winContainer.add(jB1);
        winContainer.add(jB2);
        winContainer.add(jB3);
        winContainer.add(jB4);

        this.setBounds(300,400,500,320);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jB1){
            this.setVisible(false);
            AddInfoActivity w1=new AddInfoActivity(name,flag);
        }

        if(e.getSource()==jB2){
            this.setVisible(false);
            DeleteInfoActivity w2=new DeleteInfoActivity(name);
        }

        if(e.getSource()==jB3){
            this.setVisible(false);
            ReviseInfoActivity w3=new ReviseInfoActivity(name);
        }

        if(e.getSource()==jB4){
            this.setVisible(false);
            IndexActivity w4=new IndexActivity(name);
        }
    }

    public static void main(String[] args){
        BookInfoMenu t=new BookInfoMenu("test",1);
    }
}
