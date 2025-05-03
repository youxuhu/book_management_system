import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class BookSortUI extends JFrame implements ActionListener{

    static JButton jB1;
    JTextArea textArea;
    JScrollPane scrollPane;
    int flag=0;
    String user;

    public BookSortUI(String user,int flag){
        super("书籍借阅次数排名");

        jB1=new JButton("返回");
        jB1.setBounds(100, 100, 100, 30);
        jB1.addActionListener(this);


        textArea = new JTextArea();
        textArea.setLineWrap(true); // 自动换行
        textArea.setFont(new Font("sssssssss", Font.PLAIN, 18)); // 设置字体
        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(400, 50, 500, 400);

        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);

        winContainer.add(jB1);
        winContainer.add(scrollPane);
        winContainer.add(scrollPane);
        this.setSize(1100, 500);
        this.setLocation(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        BookSortSQL.BookSort();
        textArea.setText(BookSortSQL.returnString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jB1){
            this.setVisible(false);
            SortActivities t=new SortActivities(user,flag);
        }
    }

    public static void main(String[] args){
        BookSortUI bs=new BookSortUI("test",0);
    }
}
