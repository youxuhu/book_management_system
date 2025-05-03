import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IndexActivity extends JFrame implements ActionListener {
    JLabel jL1, jL2, jLname, jL3;
    JButton jB1, jB2, jB3, jB4, jB5, jB6, SignOut,jB7,jB8;
    JTextField jF1;
    JPasswordField jP1;
    ImageIcon background;
    JPanel myPanel;
    String user;
    public IndexActivity(String user) {
        super("图书信息管理程序_操作主界面");
        jLname = new JLabel("用户名称: "+user);
        jLname.setFont(new Font("宋体", Font.BOLD, 16));
        jLname.setBounds(950, 5, 200, 30);

        jL1 = new JLabel("操作:");
        jL1.setFont(new Font("宋体", Font.BOLD, 25));
        jL1.setBounds(20, 40, 200, 30);

        jB1 = new JButton("图书信息管理");
        jB1.setBounds(100, 40, 150, 50);
        jB1.addActionListener(this);
        /*
        jB2 = new JButton("删除图书信息");
        jB2.setBounds(100, 85, 150, 30);
        jB2.addActionListener(this);

        jB3 = new JButton("修改图书信息");
        jB3.setBounds(100, 130, 150, 30);
        jB3.addActionListener(this);
        */

        jB4 = new JButton("查询图书信息");
        jB4.setBounds(100, 100, 150, 50);
        jB4.addActionListener(this);

        jB5=new JButton("借还书菜单");
        jB5.setBounds(100, 160, 150, 50);
        jB5.addActionListener(this);

        jB6=new JButton("逾期归还惩罚查询");
        jB6.setBounds(100, 220, 150, 50);
        jB6.addActionListener(this);

        jB7=new JButton("借出图书状态查询");
        jB7.setBounds(100, 280, 150, 50);
        jB7.addActionListener(this);

        jB8=new JButton("排名系统");
        jB8.setBounds(100, 340, 150, 50);
        jB8.addActionListener(this);

        SignOut = new JButton("退出登录");
        SignOut.setBounds(820, 5, 110, 50);
        SignOut.addActionListener(this);
        background = new ImageIcon(""); // 创建一个背景图片
        jL3 = new JLabel(background); // 把背景图片添加到标签里
        jL3.setBounds(200, 35, background.getIconWidth()/10, background.getIconHeight()/10); // 把标签设置为和图片等高等宽
        myPanel = (JPanel) this.getContentPane(); // 把我的面板设置为内容面板
        myPanel.setOpaque(false); // 把我的面板设置为不可视
        myPanel.setLayout(new FlowLayout()); // 把我的面板设置为流动布局
        this.getLayeredPane().setLayout(null); // 把分层面板的布局置空
        this.getLayeredPane().add(jL3, new Integer(Integer.MIN_VALUE));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container winContainer = this.getContentPane();
        winContainer.setLayout(null);
        winContainer.add(jLname);
        winContainer.add(jL1);
        winContainer.add(jB1);
        //winContainer.add(jB2);
        //winContainer.add(jB3);
        winContainer.add(jB4);
        winContainer.add(jB5);
        winContainer.add(jB6);
        winContainer.add(jB7);
        winContainer.add(jB8);
        winContainer.add(SignOut);
        this.setSize(1100, 450);
        this.setLocation(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.user=user;
    }

    public static void main(String[] args) {
        String t="test";
        IndexActivity w2 = new IndexActivity(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //书籍信息管理系统
        if (e.getSource() == jB1) {
            this.setVisible(false);
            // 添加信息
            BookInfoMenu w1=new BookInfoMenu(user,1);
        }

        if (e.getSource() == jB2) {
            this.setVisible(false);
            // 删除信息
            DeleteInfoActivity w4 = new DeleteInfoActivity(user);
        }

        if (e.getSource() == jB3) {
            this.setVisible(false);
            // 修改信息
            ReviseInfoActivity w5 = new ReviseInfoActivity(user);
        }

        if (e.getSource() == jB4) {
            this.setVisible(false);
            // 查询信息
            SearchInfoActivity w6 = new SearchInfoActivity(user,1);
        }

        //
        if(e.getSource()==jB5){
            this.setVisible(false);
            //借阅书籍
            BRMenu w2=new BRMenu(user,1);
        }

        if (e.getSource() == SignOut) {
            this.setVisible(false);
            // 登录界面
            manageLogin w1=new manageLogin();
        }

        if(e.getSource()==jB6){
            this.setVisible(false);
            PunishSysUI w6=new PunishSysUI(user,1);
        }

        if(e.getSource()==jB7){
            this.setVisible(false);
            BorrowCount w9=new BorrowCount(user,1);
        }

        if(e.getSource()==jB8){
            this.setVisible(false);
            SortActivities w10=new SortActivities(user,1);
        }
    }

}


