package day8_29.demo1;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterJFrame extends JFrame implements MouseListener {//注册页面
    public RegisterJFrame(){
        initJFrame();//初始化界面
        initImage();
        this.setVisible(true);
    }
    JButton reButton=new JButton();JButton reset=new JButton();JButton signButton=new JButton();
    JTextField uid=new JTextField();
    JTextField upw=new JTextField();
    JTextField againupw=new JTextField();
    private void initImage(){
        //注册用户名文字贴纸
        JLabel userName=new JLabel(new ImageIcon("image\\register\\注册用户名.png"));
        userName.setBounds(90, 135, 100, 17);
        this.getContentPane().add(userName);
        //用户名输入框

        uid.setBounds(195, 135, 200, 30);
        this.getContentPane().add(uid);
        //注册密码文字贴纸
        JLabel userPassword=new JLabel(new ImageIcon("image\\register\\注册密码.png"));
        userPassword.setBounds(100, 195, 100, 16);
        this.getContentPane().add(userPassword);
        //密码输入框

        upw.setBounds(195, 195, 200, 30);
        this.getContentPane().add(upw);
        //再次输入密码文字贴纸
        JLabel againUserPassword=new JLabel(new ImageIcon("image\\register\\再次输入密码.png"));
        againUserPassword.setBounds(90, 256, 100, 30);
        this.getContentPane().add(againUserPassword);
        //再次输入密码

        againupw.setBounds(195, 256, 200, 30);
        this.getContentPane().add(againupw);
        //登录按钮
        signButton.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        signButton.setBounds(30,300,120,43);
        signButton.setBorderPainted(false);
        signButton.setContentAreaFilled(false);
        signButton.addMouseListener(this);
        this.getContentPane().add(signButton);
        //注册按钮

        reButton.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        reButton.setBounds(180,300,120,43);
        reButton.setBorderPainted(false);
        reButton.setContentAreaFilled(false);
        //reButton.addMouseListener(this);
        reButton.addMouseListener(this);
        this.getContentPane().add(reButton);
        //重置按钮

        reset.setIcon(new ImageIcon("image\\register\\重置按钮.png"));
        reset.setBounds(330,300,120,43);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);
        this.getContentPane().add(reset);
        //背景
        JLabel backgroundImage=new JLabel(new ImageIcon("image\\register\\background.png"));
        backgroundImage.setBounds(0,0,470,390);
        this.getContentPane().add(backgroundImage);
    }
    private void initJFrame() {
        //设置窗口宽高
        this.setSize(488,435);
        //设置窗口相对位置
        this.setLocationRelativeTo(null);
        //取消默认位置
        this.setLayout(null);
        //设置窗口在屏幕高度
        this.setAlwaysOnTop(true);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗口标题
        this.setTitle("qdf拼图小游戏注册页面");
        //设置窗口是否可见
        //this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source==reButton){
            System.out.println("注册按钮");
            if (uid.getText().length()==0){
                SignJFrame.showJDialog("请输入用户名");
            }else if (upw.getText().length()==0){
                SignJFrame.showJDialog("请输入密码");
            }else if (againupw.getText().length()==0){
                SignJFrame.showJDialog("请再次输入密码");
            }else if (!againupw.getText().equals(upw.getText())){
                SignJFrame.showJDialog("两次密码不一致，请重新输入");
                upw.setText("");
                againupw.setText("");
            }else {
                int equal = SignJFrame.isEqual(uid.getText(), upw.getText());
                if (equal>=0){
                    SignJFrame.showJDialog("该用户已存在");
                }else {
                    SignJFrame.showJDialog("用户:'"+uid.getText()+"'注册成功");
                    userData data = new userData(uid.getText(), upw.getText());
                    SignJFrame.userData.add(data);
                    uid.setText("");
                    upw.setText("");
                    againupw.setText("");
                    try {
                        BufferedWriter bfw = new BufferedWriter(new FileWriter("src/day8_29/demo1/userInfo.txt",true));
                        bfw.newLine();
                        bfw.write("userName="+data.getUserName()+"&password="+data.getUserPassWord());
                        bfw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }else if (source==reset){
            System.out.println("重置按钮");
            uid.setText("");
            upw.setText("");
            againupw.setText("");
        }else if (signButton==source){
            this.setVisible(false);//当前窗口不可见
            try {
                new SignJFrame();//打开登录页面
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
