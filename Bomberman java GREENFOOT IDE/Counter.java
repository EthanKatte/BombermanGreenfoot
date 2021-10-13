import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));//Updates the Score with the new Score
        if(score >= 350){//End game clause
            World myWorld =getWorld();
            Land land = (Land)myWorld;
            land.end();//invokes the method end() from the world
        }
    }    
    public void addScore(){//allows the score to be increased from other classes
        score = score + 10;// increases score
    }
}
