import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movers extends Actor
{
    
    /**
     * Act - do whatever the Movers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        dmgX();
        
    }    
    int delayH = 50;
    int delayD = 0;
    int health = 1; 
    public void dmgX(){
        delayH++; 
        if(delayH >= 50){
            if((isTouching(Fire.class))||(isTouching(Creep.class))){
                health--; //will remove a health point if you are touching a creep or a fire
                delayH = 0; 
            }  
        }  

    }
    public void endX() {//Allows for the game to end when the player dies
        if(health == 0){
            delayD++; //increases the delay allowing for the image of Endgame to be put in (Saying game over)
            World myWorld =getWorld();
            Land land = (Land)myWorld;
            land.end();//invokes the end() method from the world (land)
            if(delayD == 10){
                Greenfoot.stop();//Stops the game
            }
        }
    }
    
    public void powerX(){
        if(isTouching(UpL.class)){//Increasing life powerup
            health = health + 1; 
        }
        if(isTouching(UpR.class)){//increasing range powerup
            World myWorld =getWorld();//Creates a variable 'myWorld' of type World that is equal to getWorld()
            Land land = (Land)myWorld;
            //land.rangeup(range = range + 1);
            Bombs bombs = land.getBombs();
            bombs.rangeUp();
        
        }
    }
}
