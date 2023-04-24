/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AddCharacter;

/**
 *
 * @author cathe
 */
public class Stats {
    //data members
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;
    //variables to be used for overall averages
    private static double intSumHero = 0;
    private static double strSumHero = 0;
    private static double spdSumHero = 0;
    private static double sklSumHero = 0;
    private static double staSumHero = 0;
    private static double intSumVillian = 0;
    private static double strSumVillian = 0;
    private static double spdSumVillian = 0;
    private static double sklSumVillian = 0;
    private static double staSumVillian = 0;
    

    //Empty constructor 
    public Stats(){

    }
    //constructor to assign all data members
    public Stats(int intelligence, int strength, int stamina, int speed, int skills, String team){
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
        //if character team is hero
        if (team.equals("Heroes")){
            //add to hero stat sums
            intSumHero += intelligence;
            strSumHero += strength;
            spdSumHero += speed;
            sklSumHero += skills;
            staSumHero += stamina;
        }
        //else fighter is on team villain
        else{
            //add values to villain stat sums
            intSumVillian += intelligence;
            strSumVillian += strength;
            spdSumVillian += speed;
            sklSumVillian+= skills;
            staSumVillian += stamina;
        }
        
        
    }
    //Getters and setters
    public int getIntelligence(){
        return intelligence;
    }
    public int getStrength(){
        return strength;
    }
    public int getStamina(){
        return stamina;
    }
    public int getSpeed(){
        return speed;
    }
    public int getSkills(){
        return skills;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setSkills(int skills){
        this.skills = skills;
    }
    //method to calculate the fighting power of each charatcer based on their stats
    public int getStatSum(){
        return(skills+speed+stamina+strength+intelligence);
    }
    //return overall average intelligence
    public double getAvgInt(String team, int numFightersTeam){
        //if getting heroe stats
        if (team.equals("Heroes")){
            return ((double)(intSumHero/numFightersTeam));
        }
        //else getting villian stats
        else{
            return ((double)(intSumVillian/numFightersTeam));
        }  
    }
    //return overall average Strength
    public double getAvgStr(String team, int numFightersTeam){
        //if getting heroe stats
        if (team.equals("Heroes")){
            return ((double)(strSumHero/numFightersTeam));
        }
        //else getting villian stats
        else{
            return ((double)(strSumVillian/numFightersTeam));
        } 
    }
    //return overall average Speed
    public double getAvgSpd(String team, int numFightersTeam){
        //if getting heroe stats
        if (team.equals("Heroes")){
            return ((double)(spdSumHero/numFightersTeam));
        }
        //else getting villian stats
        else{
            return ((double)(spdSumVillian/numFightersTeam));
        } 
    }
    //return overall average stamina
    public double getAvgSta(String team, int numFightersTeam){
        //if getting heroe stats
        if (team.equals("Heroes")){
            return ((double)(staSumHero/numFightersTeam));
        }
        //else getting villian stats
        else{
            return ((double)(staSumVillian/numFightersTeam));
        } 
    }
    //return overall average Skills
    public double getAvgSkl(String team, int numFightersTeam){
        //if getting heroe stats
        if (team.equals("Heroes")){
            return ((double)(sklSumHero/numFightersTeam));
        }
        //else getting villian stats
        else{
            return ((double)(sklSumVillian/numFightersTeam));
        } 
    }
    
    
    @Override
    //to string method to display all data members
    public String toString(){
        String result = "";
        //Display all stats of all chosen character object
        result += String.format("   Stats:        Intelligence: %d\n", getIntelligence());
        result += String.format("                 Strength:     %d\n", getStrength());
        result += String.format("                 Stamina:      %d\n", getStamina());
        result += String.format("                 Speed:        %d\n", getSpeed());
        result += String.format("                 Skills:       %d\n", getSkills());
        return result;
    }
}//end of stats class

