package day8_28.demo1;

public class test {
    public static void main(String[] args) {
        TableTennisPlayer tableTennisPlayer=new TableTennisPlayer("马龙",25);
        TableTennisCoach tableTennisCoach=new TableTennisCoach("李明",56);
        BasketballPlayers basketballPlayers=new BasketballPlayers("姚明",22);
        BasketballCoach basketballCoach=new BasketballCoach("王华",66);
        System.out.println(tableTennisCoach.getName()+ tableTennisCoach.getAge() );
        tableTennisCoach.teach();tableTennisCoach.Say();
        System.out.println(tableTennisPlayer.getAge()+tableTennisCoach.getName());
        tableTennisPlayer.Say();tableTennisPlayer.study();
        basketballCoach.teach();basketballPlayers.study();
    }
}
