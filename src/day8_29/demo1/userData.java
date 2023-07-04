package day8_29.demo1;

public class userData {
    private String userName;
    private String userPassWord;

    public userData() {
    }

    public userData(String userName, String userPassWord) {
        this.userName = userName;
        this.userPassWord = userPassWord;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    @Override
    public String toString() {
        return "userData{" +
                "userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }
}
