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
    int Two = 1; 
    public void blow(){
        timer--; 
        if (timer == 10) {
            getWorld().removeObject(this);
        }
    }   
    
    public void remove(){   
       Actor actor = getOneIntersectingObject(Breakblock.class);
       if (Two == 1 ) {
        getWorld().removeObject(actor);
       } 
    }
    
    
}
