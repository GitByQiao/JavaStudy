package day8_20.demo1;

public class UsersInfo {
   private String userName,passWord,idCard,phoneNumber;//用户名，密码，身份证号码，手机号码

    public UsersInfo() {
    }

    public UsersInfo(String userName, String passWord, String idCard, String phoneNumber) {
        this.userName = userName;
        this.passWord = passWord;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
