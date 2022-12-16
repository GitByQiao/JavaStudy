package day8_20.demo1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class StudentManagementHtml {
    public static void main(String[] args) {
        ArrayList<UsersInfo> usersInfos=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("--------学生管理系统：请输入对应数字进行操作；1：登录；2：注册；3：忘记密码；4:退出--------");
            String n=sc.next();
            switch (n){
                case "1":{
                    sign(usersInfos);break;
                }
                case "2":{
                    register(usersInfos);break;
                }
                case "3":{
                    forgetPassword(usersInfos);break;
                }
                case "4":{
                    System.exit(0);
                }
                default:{
                    System.out.println("请重新输入正确的指令");break;
                }
            }
        }
    }
    public static void forgetPassword(ArrayList<UsersInfo> usersInfos){
        //忘记密码：
        //1，键盘录入用户名，判断当前用户名是否存在，如不存在，直接结束方法，并提示：未注册
        //2，键盘录入身份证号码和手机号码
        //3，判断当前用户的身份证号码和手机号码是否一致，
        //如果一致，则提示输入密码，进行修改。
        //如果不一致，则提示：账号信息不匹配，修改失败。
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要找回的用户名");
        String userName=sc.next();
        boolean existenceRegister = isExistenceRegister(userName, usersInfos);//判断用户是否存在
        if (!existenceRegister){
            System.out.println("未注册");
            return;
        }
        System.out.println("请输入注册时的身份证号码");
        String idCard=sc.next();
        System.out.println("请输入注册时的手机号码");
        String phoneNumber=sc.next();
        int i = isContain(userName,  usersInfos);//获得输入的已有用户名的下标
        boolean matching = isMatching(i, idCard, phoneNumber,usersInfos);//判断当前用户的身份证号码和手机号码是否一致
        if (!matching){
            System.out.println("账号信息不匹配，修改失败");
            return;
        }
        while (true) {
            System.out.println("请输入你的新的密码");
            String passWord1=sc.next();
            System.out.println("请再次输入你的新密码");
            String passWord2=sc.next();
            if (passWord1.equals(passWord2)){
                usersInfos.get(i).setPassWord(passWord1);
                System.out.println("修改密码成功");
                return;
            }
            System.out.println("两次密码不一致请重新输入新密码");
        }
    }//忘记密码
    public static void sign(ArrayList<UsersInfo> usersInfos){
        //1，键盘录入用户名
        //2，键盘录入密码
        //3，键盘录入验证码
        //验证要求：
        //用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册
        //判断验证码是否正确，如不正确，重新输入
        //再判断用户名和密码是否正确，有3次机会
        //验证码规则：
        //长度为5
        //由4位大写或者小写字母和1位数字组成，同一个字母可重复
        //数字可以出现在任意位置
        //比如：
        //aQa1K
        Scanner sc=new Scanner(System.in);int count=0;
        String userName;String passWord;String code;//定义用户名，密码，验证码
        for (;count<3;count++) {
            System.out.println("请输入用户名");
            userName = sc.next();//输入用户名
            boolean existenceRegister = isExistenceRegister(userName, usersInfos);//该用户是否进行了注册
            if (!existenceRegister){
                System.out.println("用户名未注册，请先注册");
                return;
            }
            System.out.println("请输入密码");
            passWord = sc.next();
            while (true) {
                String existenceCode = isExistenceCode();
                System.out.println("当前正确验证码是:"+existenceCode);
                code = sc.next();
                if (!existenceCode.equalsIgnoreCase(code)){
                    System.out.println("验证码不正确，请重新输入:");
                    continue;
                }
                System.out.println("验证码正确");
                break;
            }
            boolean right = isRight(userName, passWord, usersInfos);//判断用户名和密码是否正确
            if (!right){
                System.out.println("账号或者密码错误，你还剩"+(2-count)+"次机会");
            }
            else {
                System.out.println("登录成功");
                StudentManagementSystem student=new StudentManagementSystem();
                student.startStudentManagementSystem();
                return;
            }
            if (count==2){
                System.out.println("你已经错误3次,账号已锁定");
            }
        }
    }//登录
    public static void register(ArrayList<UsersInfo> usersInfos){//注册
        //1，用户名需要满足以下要求：
        //验证要求：
        //用户名唯一
        //用户名长度必须在3~15位之间
        //只能是字母加数字的组合，但是不能是纯数字
        //2，密码键盘输入两次，两次一致才可以进行注册。
        //3，身份证号码需要验证。
        //验证要求：
        //长度为18位
        //不能以0为开头
        //前17位，必须都是数字
        //最为一位可以是数字，也可以是大写X或小写x
        //4，手机号验证。
        //验证要求：
        //长度为11位
        //不能以0为开头
        //必须都是数字
        Scanner sc = new Scanner(System.in);
        UsersInfo usersInfo = new UsersInfo();//new一个对象存储数据
        String userName;
        String userPassword1, userPassword2;
        String idCard;
        String phoneNumber;
        while (true) {
            System.out.println("请输入注册的用户名:");
            userName = sc.next();
            boolean existenceUserName = isExistenceUserName(userName, usersInfos);//判断用户名是否符合要求，true为符合要求
            if (!existenceUserName) {
                System.out.println("不正确请重新输入");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("请输入注册的密码:");
            userPassword1 = sc.next();
            System.out.println("请再输一次密码进行确定:");
            userPassword2 = sc.next();
            if (!userPassword1.equals(userPassword2)) {//判断密码是否相同，相同的话接着注册，不同重新输入密码
                System.out.println("两次密码输入不一样，请重新输入");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("请输入注册的身份证号码:");
            idCard = sc.next();
            boolean existenceIdCard = isExistenceIdCard(idCard);//验证身份证号码是否符合规范
            if (!existenceIdCard) {
                System.out.println("请输入正确规范的18位身份证号码");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("请输入注册的手机号:");
            phoneNumber = sc.next();
            boolean existencePhoneNumber = isExistencePhoneNumber(phoneNumber);
            if (!existencePhoneNumber) {
                System.out.println("请输入正确的11位手机号");
                continue;
            }
            break;
        }
        usersInfo.setUserName(userName);
        usersInfo.setPassWord(userPassword1);
        usersInfo.setIdCard(idCard);
        usersInfo.setPhoneNumber(phoneNumber);
        usersInfos.add(usersInfo);
        for (int i = 0; i < usersInfos.size(); i++) {
            UsersInfo usersInfo1 = usersInfos.get(i);
            System.out.println(usersInfo1.getUserName()+","+usersInfo1.getPassWord()+","+usersInfo1.getIdCard()+","+usersInfo1.getPhoneNumber());
        }
        System.out.println("注册成功");
        //System.out.println(usersInfos.get(0).getUserName());
    }//注册
    public static boolean isExistenceUserName(String userName,ArrayList<UsersInfo> usersInfos){//合法返回true，不合法返回false
        //验证要求：
        //用户名唯一
        //用户名长度必须在3~15位之间
        //只能是字母加数字的组合，但是不能是纯数字
        int count = 0;//计数字母个数
        for (int i = 0; i < usersInfos.size(); i++) {
            if(usersInfos.get(i).getUserName().equals(userName)){//判断用户名是否唯一
                System.out.println("用户名已存在");
                return false;
            }
        }
        if (!(userName.length()>=3&&userName.length()<=15)){//判断是否用户名长度必须在3~15位之间
            System.out.println("请确保用户名长度必须在3~15位之间");
            return false;
        }
        for (int i = 0; i < userName.length(); i++) {
            if (((userName.charAt(i)>='a'&&userName.charAt(i)<='z')||(userName.charAt(i)>='A'&&userName.charAt(i)<='Z'))){
                //只能是字母加数字的组合，但是不能是纯数字   //计入字母数量
                count++;
            }
        }
        if (count>0){//字母数大于0符合要求
            return true;
        }else {
            System.out.println("只能是字母加数字的组合，但是不能是纯数字");
            return false;
        }
    }
    //用户名验证是否合法,合法true,不合法false
    public static boolean isExistenceIdCard(String idCard){//验证身份证号码是否符合规范
        //验证要求：
        //长度为18位
        //不能以0为开头
        //前17位，必须都是数字
        //最为一位可以是数字，也可以是大写X或小写x
        if (idCard.length()!=18){//长度为18位
            return false;
        }
        if (idCard.charAt(0)=='0'){//不能以0为开头
            return false;
        }
        for (int i = 0; i < idCard.length()-1; i++) {//前17位，必须都是数字
            if (!(idCard.charAt(i)>='0'&&idCard.charAt(i)<='9')){
                return false;
            }
        }
        char c = idCard.charAt(idCard.length() - 1);
        if (!(c=='X'||c=='x'||(c>='0'&&c<='9'))){//最为一位可以是数字，也可以是大写X或小写x
            return false;
        }
        return true;
    }
    //验证身份证号码是否符合规范,符合true,不符合false
    public static boolean isExistencePhoneNumber(String phoneNumber){//判断手机号是否符合验证
        //验证要求：
        //长度为11位
        //不能以0为开头
        //必须都是数字
        if (phoneNumber.length()!=11){
            return false;
        }
        if (phoneNumber.charAt(0)=='0'){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!(phoneNumber.charAt(i)>='0'&&phoneNumber.charAt(i)<='9')){
                return false;
            }
        }
        return true;
    }
    //判断手机号是否符合验证,符合true,不符合false
    public static boolean isExistenceRegister(String userName,ArrayList<UsersInfo> usersInfos){
        for (int i = 0; i < usersInfos.size(); i++) {
            String userName1 = usersInfos.get(i).getUserName();
            if (userName1.equals(userName)){
                return true;
            }
        }
        return false;
    }
    //判断用户是否进行了注册，注册了返回true，未注册返回false
    public static String isExistenceCode(){
        ArrayList<Character> arrayList=new ArrayList<>();//定义一个集合存储a-z和A-Z字符
        StringBuilder sb=new StringBuilder();int r;//定义一个stringBuilder对象进行字符拼接
        Random random=new Random();
        for (int i = 0; i < 26; i++) {
            arrayList.add((char) ('a'+i));//把a-z和A-Z存到集合中
            arrayList.add((char) ('A'+i));
        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i));
//        }
        for (int i = 0; i < 4; i++) {
            r=random.nextInt(arrayList.size());//生成一个集合范围是随机数
            sb.append(arrayList.get(r));//把随机的字符拼接到stringBuilder容器中
        }
        r=random.nextInt(10);
        sb.append(r);
        char[] chars = sb.toString().toCharArray();//变成字符数组进行交换
        int s=random.nextInt(chars.length);//生成字符数组长度的一个随机下标
        char temp=chars[s];
        chars[s]=chars[chars.length-1];//数字的那个字符和随机一个字符交换位置
        chars[chars.length-1]=temp;
        String s1 = new String(chars);//把数组生成一个字符串对象
        //System.out.println(chars);
        return s1;
    }
    //返回生成的验证码
    public static boolean isRight(String userName,String passWord,ArrayList<UsersInfo> usersInfos){
        for (int i = 0; i < usersInfos.size();i++) {
            if (!usersInfos.get(i).getUserName().equals(userName)){
                continue;
            }
            if (!usersInfos.get(i).getPassWord().equals(passWord)){
                continue;
            }
            return true;
        }
        return false;
    }
    //判断用户名和密码是否正确
    public static int isContain(String userName, ArrayList<UsersInfo> usersInfos){
        for (int i = 0; i < usersInfos.size(); i++) {
            if (usersInfos.get(i).getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    //获得输入的已有用户名的下标
    public static boolean isMatching(int i,String idCard,String phoneNumber,ArrayList<UsersInfo> usersInfos){
        if ((usersInfos.get(i).getIdCard().equalsIgnoreCase(idCard))&&(usersInfos.get(i).getPhoneNumber().equals(phoneNumber))) {
            return true;
        }
        return false;
    }
    //判断当前用户的身份证号码和手机号码是否一致
}
