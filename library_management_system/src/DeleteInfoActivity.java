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

public class DeleteInfoActivity extends JFrame implements ActionListener {
    static BookInfoMenu w2;

    JLabel jL1, jL2, jLname,jL3;
    JButton jB1, jB2, jB3;
    JTextField jF1, jF2;
    JScrollPane scrollPane;
    JTextArea textArea;
    String user;

    public DeleteInfoActivity(String user) {
        super("图书信息管理程序_删除图书信息");
        this.user=user;
        jLname = new JLabel("用户名称: "+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);

        jL1 = new JLabel("删除的书名:");
        jL1.setFont(new Font("宋体", Font.BOLD, 20));
        jL1.setBounds(30, 60, 200, 30);

        jL2 = new JLabel("删除的简介:");
        jL2.setFont(new Font("宋体", Font.BOLD, 20));
        jL2.setBounds(30, 120, 200, 30);


        jF1 = new JTextField("", 20);
        jF1.setBounds(170, 60, 200, 30);

        jF2 = new JTextField("", 20);
        jF2.setBounds(170, 120, 200, 30);

        jB1 = new JButton("删除");
        jB1.setBounds(60, 170, 60, 30);
        jB1.addActionListener(this);

        jB2 = new JButton("返回");
        jB2.setBounds(280, 170, 60, 30);
        jB2.addActionListener(this);

        jB3 = new JButton("删除全部");
        jB3.setBounds(150, 170, 90, 30);
        jB3.addActionListener(this);

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
        winContainer.add(jB3);
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

    public static void main(String[] args) throws Exception {
        String t="";
        DeleteInfoActivity w4 = new DeleteInfoActivity(t);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == jB1) {
            if (jF1.getText().toString() != null && jF1.getText().toString().length() > 0) {
                if (jF2.getText().toString() != null && jF2.getText().toString().length() > 0) {
                    Book book = new Book(jF1.getText().toString(), jF2.getText().toString());
                    SQLTxt.deleteTxtByStr(book.delString());
                    try {
                        SQLTxt.searchAllTxtFile();
                        textArea.setText(SQLTxt.getreadStr());
                        JOptionPane.showMessageDialog(w2, "删除成功", "提示", 1);
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(w2, "删除的简介不为空", "提示", 1);
                }
            } else {
                JOptionPane.showMessageDialog(w2, "删除的书名不为空", "提示", 1);

            }

        } else if (e.getSource() == jB2) {
            this.setVisible(false);
            w2 = new BookInfoMenu(user,1);
        } else if (e.getSource() == jB3) {
            try {
                SQLTxt.deleteAllTxtFile();
                try {
                    SQLTxt.searchAllTxtFile();
                    textArea.setText(SQLTxt.getreadStr());
                    JOptionPane.showMessageDialog(w2, "删除成功", "提示", 1);
                } catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

}


