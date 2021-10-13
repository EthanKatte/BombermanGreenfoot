import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        blow(); 
    }   

    int timer = 40;
    
    public void blow(){
        timer--; //counts down from 40 by 1 every act cycle
        if (timer == 10) {
            getWorld().removeObject(this); //removes fire 
        }
    }  
    
    public void remove(){   
       World myWorld =getWorld(); //allows us to access the world class
       Actor actor = getOneIntersectingObject(Breakblock.class); //checks to see if fire is touching breakblock
       
       getWorld().removeObject(actor); //removes breakblock
        
       Actor actorX = getOneIntersectingObject(Creep.class); //checks to see if fire is touching creep
       getWorld().removeObject(actorX); //removes creep
       
       if((actor != null)||(actorX !=null)){ //checks to see if the fire is toucing either the creep or the breakblock 
         Land land = (Land)myWorld;
         Counter counter = land.getCounter();
         counter.addScore();
        }   
    }
}