import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bombs extends Actor
{
    int range = 1;
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        blow();
    }   
    
     int timer = 100; //sets up the timer
    public void rangeUp(){
        range = range + 1; //adds one to range 
        
    }
    public void blow(){
        timer--; //counts down the timer
        if(timer == 10){
            for(int i = 1; i<=range; i++){ //allows us to infinitely add range to our fire
                getWorld().addObject(new Fire(),getX(),getY() + 10*i);
                getWorld().addObject(new Fire(),getX(),getY() - 10*i);
                getWorld().addObject(new Fire(),getX() + 10*i,getY() );
                getWorld().addObject(new Fire(),getX() - 10*i,getY() );
            }
        }
              
        
        if (timer == 0) { //removes the bomb after 100 act cycles
            getWorld().removeObject(this); //removes the bomb
            timer = 100; //resets the timer
        }
        
    }
    

}
