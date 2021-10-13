import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bombs extends Actor
{
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        blow(); 
    }   
    
    int timer = 100;
 
    public void blow(){
        timer--;  
        if (timer == 0) {
            getWorld().removeObject(this);
            
        }
        if(timer == 10) {
            getWorld().addObject(new Fire(),getX(),getY() + 10);
            getWorld().addObject(new Fire(),getX(),getY() - 10);
            getWorld().addObject(new Fire(),getX() + 10,getY() );
            getWorld().addObject(new Fire(),getX() - 10,getY() );
        }
    }
}
