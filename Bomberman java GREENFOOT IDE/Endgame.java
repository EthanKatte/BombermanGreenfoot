import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endgame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Endgame extends Actor
{
    /**
     * Act - do whatever the Endgame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Game Over", 100, Color.GREEN, Color.BLACK));//Sets the "Game Over" image
    }    
}
