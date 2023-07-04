package day8_29.demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//java窗口上先设置的界面在上层
public class SignJFrame extends JFrame implements MouseListener {//登录页面
    //存储用户名和密码的集合
    static ArrayList<userData> userData = new ArrayList<>();

    //构造方法
    public SignJFrame() throws IOException {
        initUserInfo();//读取存在文本的用户名和密码
        initSignJFrame();//初始化窗口页面
        initImage();//初始化图片
        this.setVisible(true);//设置当前界面可见
    }

    //读取存在文本的用户名和密码并存入集合userData
    private void initUserInfo() throws IOException {
        BufferedReader bfw = new BufferedReader(new FileReader("src\\day8_29\\demo1\\userInfo.txt"));
        String userInfo;
        while ((userInfo = bfw.readLine()) != null) {
            String[] user = userInfo.split("&");
            String[] userNameInfoStr = user[0].split("=");
            String[] passwordInfoStr = user[1].split("=");
            userData.add(new userData(userNameInfoStr[1], passwordInfoStr[1]));
        }
        bfw.close();
        //System.out.println(userData);
    }

    //初始化窗口页面
    private void initSignJFrame() {
        //设置窗口宽高
        this.setSize(488, 430);
        //设置窗口相对位置
        this.setLocationRelativeTo(null);
        //取消内部默认格式
        this.setLayout(null);
        //设置窗口在屏幕高度
        this.setAlwaysOnTop(true);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗口标题
        this.setTitle("qdf拼图小游戏登录页面");
        //设置窗口是否可见
        //this.setVisible(true);
    }

    JButton signButton = new JButton();//创建登录按钮
    JButton registerButton = new JButton();//创建注册按钮
    JLabel rightCode = new JLabel();//验证码图片
    JLabel userName = new JLabel(new ImageIcon("image\\login\\用户名.png"));
    JLabel userPassWord = new JLabel(new ImageIcon("image\\login\\密码.png"));
    JLabel code = new JLabel(new ImageIcon("image\\login\\验证码.png"));
    JLabel backgroundColor = new JLabel(new ImageIcon("image\\login\\background.png"));
    JTextField password = new JTextField();//密码输入框
    JTextField name = new JTextField();//用户名输入框
    JTextField randomCode = new JTextField();//验证码输入框
    RandomCode randomCode1 = new RandomCode();//生成的验证码
    String code1 = randomCode1.randomCode();//生成的验证码
    JLabel exchangeCode = new JLabel("换一个验证码");

    public void initImage() {
//        创建JLabel添加用户名文字
//        对用户名文字设置位置和宽高：116, 135, 51, 19

        userName.setBounds(116, 135, 51, 19);
        this.getContentPane().add(userName);
//        创建用户名的文本输入框：JTextField
//        对用户名的文本输入框设置位置和宽高：195, 134, 200, 30

        name.setBounds(195, 134, 200, 30);
        this.getContentPane().add(name);
//        创建JLabel添加密码文字
//        对密码文字设置位置和宽高：130, 195, 35, 18

        userPassWord.setBounds(130, 195, 35, 18);
        this.getContentPane().add(userPassWord);
//        创建密码的文本输入框：JTextField
//        对密码的文本输入框设置位置和宽高：195, 195, 200, 30

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);
//        创建登录的按钮：JButton
//                利用setIcon方法给登录按钮设置背景色
//        对登录的按钮设置位置和宽高：133, 260, 90, 40

//       创建验证码

        code.setBounds(130, 250, 50, 30);
        this.getContentPane().add(code);

        randomCode.setBounds(195, 250, 100, 30);
        this.getContentPane().add(randomCode);
        //随机生成验证码

        rightCode.setText(code1);
        rightCode.setBounds(310, 250, 150, 40);
        this.getContentPane().add(rightCode);
        //提示换一个验证码

        exchangeCode.setBounds(350, 250, 150, 40);
        exchangeCode.setFont(new Font("宋体", Font.PLAIN, 16));
        exchangeCode.setForeground(Color.red);
        this.getContentPane().add(exchangeCode);
        exchangeCode.addMouseListener(this);
        //登录按钮
        signButton.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        signButton.setBounds(110, 300, 150, 47);
        signButton.setBorderPainted(false);
        signButton.setContentAreaFilled(false);
        signButton.addMouseListener(this);
        this.getContentPane().add(signButton);
//        创建注册的按钮：JButton
//                利用setIcon方法给注册按钮设置背景色
//        对注册的按钮设置位置和宽高：256, 260, 90, 40

        registerButton.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        registerButton.setBounds(280, 300, 150, 47);
        registerButton.setBorderPainted(false);//取消按钮边框
        registerButton.setContentAreaFilled(false);//去掉按钮背景
        registerButton.addMouseListener(this);//按钮点击事件
        this.getContentPane().add(registerButton);

//        创建背景色：JLabel
//        给背景色设置位置和宽高：0, 0, 470, 390

        backgroundColor.setBounds(0, 0, 470, 390);
        this.getContentPane().add(backgroundColor);
//        将上面7个组件添加到主界面的中心面板中
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object eSource = e.getSource();
        if (eSource == registerButton) {
            System.out.println("注册按钮");
            this.setVisible(false);
            new RegisterJFrame();//打开一个注册界面
        } else if (eSource == signButton) {
            System.out.println("登录按钮");
            if (code1.equalsIgnoreCase(randomCode.getText())) {//判断验证码是否正确
                System.out.println("验证码正确");
                if (isEqual(name.getText(), password.getText()) >= 0) {//判断账号密码是否正确
                    this.setVisible(false);
                    new GameJFrame();//正确就打开游戏界面
                } else {
                    showJDialog("账号或者密码错误");
                }
            } else if (randomCode.getText().length() == 0) {
                showJDialog("请输入验证码");
            } else {
                showJDialog("验证码错误,请重新输入验证码");
            }
        } else if (eSource == exchangeCode) {
            System.out.println("换一个验证码");
            RandomCode exchangeCode = new RandomCode();
            code1 = exchangeCode.randomCode();
            rightCode.setText(code1);
        }
    }

    public static void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(400, 300);
        jDialog.setLayout(null);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(40, 0, 400, 300);
        warning.setFont(new Font("楷书", Font.BOLD, 20));
        warning.setBackground(Color.red);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object eSource = e.getSource();
        if (eSource == registerButton) {
            //System.out.println("注册按钮");
            registerButton.setIcon(new ImageIcon("image\\login\\注册按下2.png"));
        } else if (eSource == signButton) {
            //System.out.println("登录按钮");
            signButton.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object eSource = e.getSource();
        if (eSource == registerButton) {
            //System.out.println("注册按钮");
            registerButton.setIcon(new ImageIcon("image\\login\\注册按下2.png"));
        } else if (eSource == signButton) {
            //System.out.println("登录按钮");
            signButton.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static int isEqual(String nameS, String passwordS) {
        //判断用户账号，密码是否正确
        for (int i = 0; i < userData.size(); i++) {
            String uid = userData.get(i).getUserName();
            String upw = userData.get(i).getUserPassWord();
            if (nameS.equals(uid) && passwordS.equals(upw)) {
                return i;
            }
        }
        return -1;
    }
}
