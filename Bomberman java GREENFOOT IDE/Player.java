import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Movers
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
     {
        movement();             //Act methods
        animation();
        bombs();
        dmgX();//X means the method is in the parent class
        powerX();
        endX();//X means the method is in the parent class
    } 
    
     
    //Setting Variables
    int delay = 100; 
    int health = 1; 
    int Fpiccounter = 0;
    String Currentkey;
    
    public void movement(){ //Movement Method
            if (Greenfoot.isKeyDown("a")){ //Checking if the corresponding movement key is down
                    setRotation(0);//Setting the direction of movement
                    move(-1);//Moving
                    if((isTouching(Solidblock.class))|| (isTouching(Breakblock.class))){
                        move(1);//Correcting the movement if you hit a wall
                    }
            }
            if (Greenfoot.isKeyDown("s")){//Checking if the corresponding movement key is down
                    setRotation(90);//Setting the direction of movement
                    move(1);//Moving
                    if((isTouching(Solidblock.class))|| (isTouching(Breakblock.class))){
                        move(-1);//Correcting the movement if you hit a wall
                    }
            }
            if (Greenfoot.isKeyDown("w")){//Checking if the corresponding movement key is down
                    setRotation(90);//Setting the direction of movement
                    move(-1);//Moving
                    if((isTouching(Solidblock.class))|| (isTouching(Breakblock.class))){
                        move(1);//Correcting the movement if you hit a wall
                    }
            }
            if (Greenfoot.isKeyDown("d")){//Checking if the corresponding movement key is down
                    setRotation(0);//Setting the direction of movement
                    move(1);//Moving
                    if((isTouching(Solidblock.class))|| (isTouching(Breakblock.class))){
                        move(-1);//Correcting the movement if you hit a wall
                    }
                }
    }

    public void bombs(){//Bombs method
        delay++; //creates a delay between the placing of the bombs and the explosion
        World myWorld = getWorld();
        Land land = (Land)myWorld;
        
           if (delay >= 100) {//allows for the explosion
               if (Greenfoot.isKeyDown("l")){ //places a bomb
                    
                    getWorld().addObject(land.bombs,getX(),getY());//places a bomb
                    delay = 0;                      //resets the delay
               }
           }
    }
    

    public void animation(){
        String[] Frontimages = {"PlayerF1.png","PlayerF2.png","PlayerF3.png","PlayerF4.png","PlayerF5.png","PlayerF6.png","PlayerF7.png","PlayerF8.png"};//List of Image file names for 'S' moves
        String[] Backimages = {"PlayerB1.png","PlayerB2.png","PlayerB3.png","PlayerB4.png","PlayerB5.png","PlayerB6.png","PlayerB7.png","PlayerB8.png"};//List of Image file names for 'W' moves
        String[] Rightimages = {"PlayerR1.png","PlayerR2.png","PlayerR3.png","PlayerR4.png","PlayerR5.png","PlayerR6.png","PlayerR7.png","PlayerR8.png"};//List of Image file names for 'D' moves
        String[] Leftimages = {"PlayerL1.png","PlayerL2.png","PlayerL3.png","PlayerL4.png","PlayerL5.png","PlayerL6.png","PlayerL7.png","PlayerL8.png"};//List of Image file names for 'A' moves
        ///System.out.println(Greenfoot.getKey());

        if(Greenfoot.isKeyDown("a")){Currentkey = "a";}//Sees what key is down
        if(Greenfoot.isKeyDown("s")){Currentkey = "s";}///////////////////////
        if(Greenfoot.isKeyDown("w")){Currentkey = "w";}///////////////////////
        if(Greenfoot.isKeyDown("d")){Currentkey = "d";}///////////////////////

        if(Currentkey == "d"){//Sets the list of animations that will be cycled through
            if(Fpiccounter == 8){
                Fpiccounter = 0;
            }
            else{
                setImage(Rightimages[Fpiccounter]);
                Fpiccounter = Fpiccounter + 1;
            }
        }
        if(Currentkey == "s"){//Sets the list of animations that will be cycled through
            if(Fpiccounter == 8){
                Fpiccounter = 0; // resets the cycle of the 8 images back to the first one
            }
            else{
                setImage(Frontimages[Fpiccounter]);//Chooses which image is shown
                Fpiccounter = Fpiccounter + 1;//moves the counter up to progress to the next image
            }
        }
        if(Currentkey == "w"){//Sets the list of animations that will be cycled through
            if(Fpiccounter == 8){
                Fpiccounter = 0;// resets the cycle of the 8 images back to the first one
            }
            else{
                setImage(Backimages[Fpiccounter]);//Chooses which image is shown
                Fpiccounter = Fpiccounter + 1;//moves the counter up to progress to the next image
            }
        }
        if(Currentkey == "a"){//Sets the list of animations that will be cycled through
            if(Fpiccounter == 8){
                Fpiccounter = 0;// resets the cycle of the 8 images back to the first one
            }
            else{
                setImage(Leftimages[Fpiccounter]);//Chooses which image is shown
                Fpiccounter = Fpiccounter + 1;//moves the counter up to progress to the next image
            }
        }
    }
}