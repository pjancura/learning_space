package java_17.generics;

import org.xml.sax.SAXException;

/*  Declaring a generic class
 *      public class YouTellMe<T> {
 *          private T field
 *      }
 * 
 *      T is the placeholder for a type that will be specified later
 *          commonly called a "type identifier", and it can be any letter or 
 *          word, but T which is short for Type is commonly used
 * 
 *  ArrayList<T> is an example of a generic class, because I specify the type upon instantiation
 * 
 * 
 */

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player {}

record FootballPlayer(String name, String position) implements Player {}

public class Main {
    
    public static void main(String[] args) {

        // initial implementation of the BaseballTeam class
        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");

        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMember();

        // second implementation...coding using the interface 
        SportTeam phillies2 = new SportTeam("Philadelphia Phillies");
        SportTeam astros2 = new SportTeam("Houston Astros");

        scoreResult(phillies2, 3, astros2, 5);
            // the interface allows me to use the SportTeam class and add either a football or baseball player to the team
            // however there is no type safety (say...adding a football player to a baseball team)
        SportTeam afc = new SportTeam("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        afc.listTeamMember();

        // this will implement the generic class Team.java
        Team<BaseballPlayer, Affiliation> phillies3 = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer, Affiliation> astros3 = new Team<>("Houston Astros");

        scoreResult(phillies3, 3, astros3, 5);

            // with adding the generic class of Team and specifying the type to use (like in List<???>)
            // I will not be able to add a BaseballPlayer to a FootballPlayer team
        var crowsAffiliation = new Affiliation("Melbourne", "City", "AUS");
        Team<FootballPlayer, Affiliation> afc2 = new Team<>("Adelaide Crows", crowsAffiliation);
        var tex2 = new FootballPlayer("Tex Walker", "Centre half forward");
        afc2.addTeamMember(tex2);
        var roy = new FootballPlayer("Rory Laird", "Midfield");
        afc2.addTeamMember(roy);
        afc2.listTeamMember();
        
        // the next 6 lines compiled because there was no upper bound of types that could be used with Team
        // Team<String> adelaide = new Team<>("Adelaide Storm");
        // adelaide.addTeamMember("N Roberts");
        // adelaide.listTeamMember();
        // var canberra = new Team<String>("Canberra Heat");
        // canberra.addTeamMember("B Black");
        // scoreResult(canberra, 0, adelaide, 1);


    }

    public static void scoreResult(BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportTeam team1, int t1_score, SportTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    
    public static void scoreResult(Team team1, int t1_score, Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}



