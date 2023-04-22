/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AddCharacter;

/**
 *
 * @author cathe
 */
public class character {
    //connects to stats class and is super of SuperHV class
    //class data memebers
    private String name;
    private String team;
    private Stats s;

    //empty constructor
    public character(){
        s = new Stats();
    }
    //constructor to assign all of the data memebers
    public character(String name, String team, int intelligence, int strength, int stamina, int speed, int skills){
        this.name = name;
        this.team = team;
        //create stats class to save statistics for this character object;
        s = new Stats(intelligence, strength, stamina, speed, skills, team);
    }
    //Getters and Setters
    public String getName(){
        return name;
    }
    public String getTeam(){
        return team;
    }

    public Stats getStats(){
        return s;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTeam(String team){
        this.team = team;
    }

    public void setStats(int intelligence, int strength, int stamina, int speed, int skills, String team){
        s = new Stats(intelligence, strength, stamina, speed, skills, team);
    }
    //To string method for character display
    @Override
    public String toString(){
        String result = "";
        //display data members within selected character object
        
        result += String.format("   Name:         %s\n", getName());
        result += String.format("   Team:         %s\n", getTeam());
        result += getStats().toString();
        //return string value to call
        return result;
    }
}//end class
    

