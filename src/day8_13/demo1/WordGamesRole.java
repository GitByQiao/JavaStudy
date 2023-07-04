package day8_13.demo1;

import java.util.Random;

public class WordGamesRole {
    private String name;
    private int blood;
    private String face;
    private char gender;



    private String[] boyFaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    private String[] girlFaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};
    private String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"};
    private String[] injured_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"};
    public WordGamesRole(){
        //System.out.println("............"+"\t\t"+"战斗开始"+"\t\t"+"...............");
    }
    public WordGamesRole(String name, int blood,char gender) {//角色赋予属性
        this.name = name;
        this.blood = blood;
        this.gender=gender;
        RoleInform();
    }
    public String[] getBoyFaces() {
        return boyFaces;
    }
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setBoyFaces(String[] boyFaces) {
        this.boyFaces = boyFaces;
    }

    public String[] getGirlFaces() {
        return girlFaces;
    }

    public void setGirlFaces(String[] girlFaces) {
        this.girlFaces = girlFaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }
    public void stack(WordGamesRole role){//攻击程序
        //xx攻击yy,yy失去了多少血量，yy还剩多少血量;
        Random random=new Random();
        int hurt=random.nextInt(20)+1;//随机伤害
        int attackIndex=random.nextInt(attacks_desc.length);//随机招数
        System.out.printf(attacks_desc[attackIndex],this.name,role.name);//使用招数
        int remain=role.getBlood()-hurt;//剩余血量
        int i = remain <= 0 ? 0 : remain;//判断是否死亡
        role.setBlood(i);//更新血量
        if(role.blood>=90)//判断状态
        {
            System.out.printf(injured_desc[0],role.name);
        }else if (role.blood>=77){
            System.out.printf(injured_desc[1],role.name);
        }else if (role.blood>=65){
            System.out.printf(injured_desc[2],role.name);
        }else if (role.blood>=50){
            System.out.printf(injured_desc[3],role.name);
        }else if (role.blood>=40){
            System.out.printf(injured_desc[4],role.name);
        }else if (role.blood>=22){
            System.out.printf(injured_desc[5],role.name);
        }else if (role.blood>=13){
            System.out.printf(injured_desc[6],role.name);
        }else {
            System.out.printf(injured_desc[7],role.name);
        }
        System.out.println(this.name+"的攻击对"+role.name+"造成了"+hurt+"点伤害。"+role.name+"还剩"+role.getBlood()+"点血量");
    }
    public void RoleInform(){//人物信息
        Random random=new Random();
        int boy=random.nextInt(boyFaces.length);
        int girl=random.nextInt(girlFaces.length);
        if (gender=='男')
        {
            this.face=boyFaces[boy];
        }
        if (gender=='女'){
            this.face=girlFaces[girl];
        }
        System.out.println("姓名:"+this.getName());
        System.out.println("性别:"+this.getGender());
        System.out.println("长相:"+this.face);
    }
}
