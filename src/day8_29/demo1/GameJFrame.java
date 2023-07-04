package day8_29.demo1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {//主页面，游戏页面
    public GameJFrame(){
        //初始化照片路径
        initImagePath();
        //创建一个窗口
        initJFrame();
        //创建一个菜单
        initMenuBar();
        //初始化数据（打乱）
        initData();
        //创建一个容器并储存照片
        initImage();
        //设置窗口是否可见
        this.setVisible(true);
    }
//    Random ok=new Random();
//    int zz=ok.nextInt(13)+1;
    String imagePath="";

    int step=0;//计算走的步数
    JMenuItem againStartGameJMenuItem=new JMenuItem("重新游戏");//创建菜单长条的菜单的条目对象
    JMenuItem againRegisterGameJMenuItem=new JMenuItem("重新登陆");//创建菜单长条的菜单的条目对象
    JMenuItem closeGameJMenuItem=new JMenuItem("关闭游戏");//创建菜单长条的菜单的条目对象
    JMenuItem beautyJMenuItem=new JMenuItem("美女");//创建菜单长条的菜单的条目对象
    JMenuItem animalJMenuItem=new JMenuItem("动物");//创建菜单长条的菜单的条目对象
    JMenuItem sportsJMenuItem=new JMenuItem("运动");//创建菜单长条的菜单的条目对象
    JMenuItem officialAccount=new JMenuItem("微信号");//创建菜单长条的菜单的条目对象
    //创建初始化二维数组存储图片下标
    int[][] randomData=new int[4][4];
    int x=0,y=0;//用来记录二维数组中0的行和列
    private void initData() {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int r = random.nextInt(data.length);
            int temp = data[r];
            data[r] = data[i];
            data[i] = temp;
        }
        /*for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }*/
        //System.out.println("");
        int count=0;
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                randomData[i][j]=data[count];
                if (data[count]==0)
                {
                    x=i;y=j;
                }
                count++;
                //System.out.print(randomData[i][j]+" ");
            }
            //System.out.println("");
        }
    }

    private void initImage() {//把照片排列到容器内
        //删除所有内容
        this.getContentPane().removeAll();
        if(vector()){
            JLabel win=new JLabel(new ImageIcon("image\\win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
            this.getContentPane().repaint();
        }
        JLabel stepText=new JLabel("步数"+step);//添加显示步数容器
        stepText.setBounds(50,30,100,20);//设置显示步数位置
        this.getContentPane().add(stepText);//界面添加显示步数容器
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                //使用随机生成的二维数组下标打乱图片顺序
                int count = randomData[i][j];
                //创建一个容器储存文字或者图片
                //把图片对象放进容器最中间
                JLabel label=new JLabel(
                        //创建一个图片对象
                        new ImageIcon(imagePath+count+".jpg"));
                //把图片对象放进容器最左边中间
                //label.setIcon(icon);

                //设置图片位置到界面的中央偏下方
                label.setBounds(105*j+83,105*i+134,105,105);
                //给照片添加下凹的边框
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把容器放在隐藏容器中上，管理容器添加到界面中
                this.getContentPane().add(label);
            }
        }
        //添加背景照片   后添加的照片在下方   模块下相对路径
        JLabel backgroundImage=new JLabel(new ImageIcon("image\\background.png"));
        //设置带照片的容器的大小
        backgroundImage.setBounds(40,40,508,560);
        //页面上添加带照片的容器
        this.getContentPane().add(backgroundImage);
        //刷新一下
        this.getContentPane().repaint();
    }

    private void initMenuBar() {
        JMenuBar jMenuBar=new JMenuBar();//创建菜单长条对象

        JMenu functionJMenu=new JMenu("功能");//创建菜单长条的菜单对象
        JMenu aboutJMenu=new JMenu("关于我");//创建菜单长条的菜单对象
        JMenu exchangeImage=new JMenu("更换照片");//创建菜单长条的菜单对象

        againRegisterGameJMenuItem.addActionListener(this);//添加鼠标点击事件
        againStartGameJMenuItem.addActionListener(this);//添加鼠标点击事件
        closeGameJMenuItem.addActionListener(this);//添加鼠标点击事件
        officialAccount.addActionListener(this);//添加鼠标点击事件
        beautyJMenuItem.addActionListener(this);
        animalJMenuItem.addActionListener(this);
        sportsJMenuItem.addActionListener(this);
        //将条目对象添加到菜单目录中
        functionJMenu.add(exchangeImage);//把更换照片放到功能里面
        functionJMenu.add(againStartGameJMenuItem);//把重新游戏放到功能里面
        functionJMenu.add(againRegisterGameJMenuItem);//把重新登陆放到功能里面
        functionJMenu.add(closeGameJMenuItem);//把关闭游戏放到功能里面
        aboutJMenu.add(officialAccount);//把二维码放到关于我里面
        exchangeImage.add(beautyJMenuItem);
        exchangeImage.add(animalJMenuItem);
        exchangeImage.add(sportsJMenuItem);
        //将菜单目录添加到菜单长条中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //将菜单长条对象设置到窗口上
        setJMenuBar(jMenuBar);
    }//初始化菜单

    private void initJFrame() {
        //设置窗口宽高
        this.setSize(603,680);
        //设置窗口相对位置
        this.setLocationRelativeTo(null);
        //设置窗口在屏幕高度
        this.setAlwaysOnTop(true);
        //取消默认的居中设置，只有取消了才会按照默认的X，Y形式添加组件
        this.setLayout(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //在窗口界面添加键盘监听事件
        this.addKeyListener(this);
        //设置窗口标题
        this.setTitle("拼图小游戏");
    }
    public void initImagePath(){
        Random random=new Random();
        int r=random.nextInt(3);
        int girl=random.nextInt(13)+1;
        int animal=random.nextInt(8)+1;
        int sport=random.nextInt(10)+1;
        if (r==0){
            imagePath="image\\girl\\"+"girl"+girl+"\\";
        }else if (r==1){
            imagePath="image\\animal\\"+"animal"+animal+"\\";
        }else {
            imagePath="image\\sport\\"+"sport"+sport+"\\";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {//一直按住键盘时执行
        if (vector()){
            return;
        }
        int keyCode = e.getKeyCode();//松开的键盘按键编码
        if (keyCode==65){
            System.out.println("A");
            this.getContentPane().removeAll();//删除所有容器内部内容
            JLabel allImage=new JLabel(new ImageIcon(imagePath+"all.jpg"));//完全图
            JLabel backgroundImage=new JLabel(new ImageIcon("image\\background.png"));//背景图
            allImage.setBounds(83,134,420,420);//完全图大小位置
            backgroundImage.setBounds(40,40,508,560);//背景位置大小
            this.getContentPane().add(allImage);//添加完全图
            this.getContentPane().add(backgroundImage);//添加背景
            this.getContentPane().repaint();//刷新
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {//送开键盘时执行
        if (vector()){
            return;
        }
        int keyCode = e.getKeyCode();//松开的键盘按键编码
        //System.out.println(keyCode);
        if (keyCode==37){
            System.out.println(keyCode+"向左移动");
            if (y!=0){
                int temp=randomData[x][y];
                randomData[x][y]=randomData[x][y-1];
                randomData[x][y-1]=temp;
                y--;
                step++;
            }
        }else if (keyCode==38){
            System.out.println(keyCode+"向上移动");
            if (x!=0){
                int temp=randomData[x][y];
                randomData[x][y]=randomData[x-1][y];
                randomData[x-1][y]=temp;
                x--;
                step++;
            }
        }else if (keyCode==39){
            System.out.println(keyCode+"向右移动");
            if (y != 3) {
                int temp = randomData[x][y];
                randomData[x][y] = randomData[x][y+1];
                randomData[x][y+1] = temp;
                y++;
                step++;
            }
        }else if (keyCode==40){
            System.out.println(keyCode+"向下移动");
            if (x != 3) {
                int temp = randomData[x][y];
                randomData[x][y] = randomData[x+1][y];
                randomData[x+1][y] = temp;
                x++;
                step++;
            }
        }else if (keyCode==87){
            System.out.println(keyCode+"自动通关");
            randomData=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
        }
        initImage();//初始化照片
        //System.out.println("键盘松开");
    }
    public boolean vector(){//判断是否胜利
        int count=1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(!(i==3&&j==3)){
                    if (randomData[i][j]!=count){
                        return false;
                    }
                }else if (randomData[i][j] != 0){
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==againStartGameJMenuItem) {
            System.out.println("重新游戏");
            //初始化随机数组生成照片
            initData();
            //步数重新计算
            step=0;
            //重新生成照片
            initImage();
        }else if (source==againRegisterGameJMenuItem){
            System.out.println("重新登陆");
            this.setVisible(false);
            try {
                new SignJFrame();//重新登陆
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if (source==closeGameJMenuItem){
            System.out.println("关闭游戏");
            System.exit(0);
        }else if (source==officialAccount){
            System.out.println("微信号");
            JDialog dialog=new JDialog();//设置一个弹窗容器对象
            JLabel account=new JLabel(new ImageIcon("image\\wxAbout.png"));//创建一个管理照片对象的容器对象
            account.setBounds(0,0,430,430);//设置相对于弹窗的位置
            dialog.getContentPane().add(account);//将管理照片对象的容器对象添加到弹窗容器中
            dialog.setSize(450,450);//给弹窗设置大小
            dialog.setAlwaysOnTop(true);//弹窗置顶
            dialog.setLocationRelativeTo(null);//弹窗居中
            dialog.setModal(true);//弹窗不关闭，不能进行下界操作
            dialog.setVisible(true);//显示弹窗
        }else if (source==beautyJMenuItem){
            System.out.println("美女");
            step=0;
            Random random=new Random();
            int r=random.nextInt(13)+1;
            imagePath="image\\girl\\"+"girl"+r+"\\";
            initData();
            initImage();
        }else if (source==animalJMenuItem){
            System.out.println("动物");
            step=0;
            Random random=new Random();
            int r=random.nextInt(8)+1;
            imagePath="image\\animal\\"+"animal"+r+"\\";
            initData();
            initImage();
        }else if (source==sportsJMenuItem){
            System.out.println("运动");
            step=0;
            Random random=new Random();
            int r=random.nextInt(10)+1;
            imagePath="image\\sport\\"+"sport"+r+"\\";
            initData();
            initImage();
        }
    }
}
