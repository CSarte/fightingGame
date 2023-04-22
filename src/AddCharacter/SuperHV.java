/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AddCharacter;

/**
 *
 * @author cathe
 */
import java.util.*;
public class SuperHV extends character{

    private ArrayList<String> powers = new ArrayList<String>();
    //collection of all the powers
    private static ArrayList<String> powerHero = new ArrayList<String>();
    private static ArrayList<String> powerVillian = new ArrayList<String>();

    

    
    // empty constructor
    public SuperHV(){

    }
    //constuctor to assign all of the values inputed form the user
    public SuperHV(String name, String team, int intelligence, int strength, int stamina, int speed, int skills){
        //create super character class for superhero class   
        super(name, team, intelligence, strength, stamina, speed, skills);
                
        }
    

    
    //Getters and Setters
    public ArrayList<String> getPowers(){
        return powers;
    }
     //method to get one of the power collection lists
     public ArrayList<String> getPowerList(String team){
        //check if team marvel is requested

        if (team.equals("Heroes")){
            Collections.sort(powerHero);
            return powerHero;

        }
        //else marvel villin list is requested
        else{
            Collections.sort(powerVillian);
            return powerVillian;

        }
        
     }

    //method to give superhv character another power
    public void addPower(ArrayList<String> power){
        boolean firstadd = false;
        if (powers.isEmpty()){
            this.powers = power;
            firstadd = true;
            for(int i = 0; i < powers.size(); i ++){
                //add power at index i to power list           
                //savevalues for total power collection
                //if character is on hero team and the heroes power list does not have this power yet
                if (getTeam().equals("Heroes") & (!(powerHero.contains(powers.get(i))))){
                    //add power to hero power list
                    powerHero.add(powers.get(i));
                }
                //else fighter is on villian team and if power villian list does not have the power yet
                else if (getTeam().equals("Villains") & (!(powerHero.contains(powers.get(i))))){
                   //add power to villian power list
                    powerVillian.add(powers.get(i));
                }
            }
        }
            
        //if this is not the first time the user is adding powers
        if (!firstadd){
            //loop until all powers are added to array list
            for(int i = 0; i < power.size(); i ++){

                //if power does not already contains desired value to add
                if (!(powers.contains(power.get(i)))){
                    powers.add(power.get(i));
                    System.out.print(String.format("   %s now has the new superpower of %s.\n", getName(), power));   
                    //add power at index i to power list           
                    //savevalues for total power collection
                    //if character is on hero team and the heroes power list does not have this power yet
                    if (getTeam().equals("Heroes") & (!(powerHero.contains(power.get(i))))){
                        //add power to hero power list
                        powerHero.add(power.get(i));
                    }
                    //else fighter is on villian team and if power villian list does not have the power yet
                    else if (getTeam().equals("Villians") & (!(powerHero.contains(power.get(i))))){
                       //add power to villian power list
                        powerVillian.add(power.get(i));
                    }

                }
                //else list already contains value
                else{
                    System.out.print(String.format("   ERROR: %s already has the superpower of %s.\n", getName(), power));
                }
            }
            
        }
    }
        
    @Override
    //Method to display superhero character class data memebers and details
    public String toString(){
        //display data members within selected superhero character object
        return String.format("%s   Powers:       %s\n", super.toString(), String.join(", ",getPowers()));
    }
}
    

        



