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
        movement();
        animation();
        bombs();
        
    } 
    
    int delay = 100; 
    int stock = 0; 
    int Two = 1; 
    int Lwall = 0;
    int Bwall = 0;
    int Twall = 0;
    int Rwall = 0;
    int Fpiccounter = 0;
    String key = Greenfoot.getKey();
    
    public void bombs(){
        delay++; 
        if (stock <= 0){
           if (delay >= 100) {
               if (Greenfoot.isKeyDown("l")){
                    getWorld().addObject(new Bombs(),getX(),getY());
                    delay = 0; 
                     
               }
           }
        }
    }
    
    public void movement(){
            

            if (Greenfoot.isKeyDown("a")){
                if(Lwall == 0){
                    setRotation(0);
                    Bwall = 0;
                    Twall = 0;
                    Rwall = 0;
                    if(isTouching(Solidblock.class)){
                        setLocation(getX()+1, getY());
                        Lwall = 1;
                    }
                    else{move(-1);}
                }
            }
            if (Greenfoot.isKeyDown("s")){
                if(Bwall == 0){
                    setRotation(90);
                    Lwall = 0;
                    Twall = 0;
                    Rwall = 0;
                    if(isTouching(Solidblock.class)){
                        move(-1);
                        Bwall = 0;
                    }
                    else{move(1);}
                }
            }
            if (Greenfoot.isKeyDown("w")){
                if(Twall == 0){
                    setRotation(90);
                    Lwall = 0;
                    Bwall = 0;
                    Rwall = 0;
                    if(isTouching(Solidblock.class)){
                        move(1);
                        Twall = 0;
                    }
                    else{move(-1);}
                }
            }
            if (Greenfoot.isKeyDown("d")){
                if(Rwall == 0){
                    setRotation(0);
                    Bwall = 0;
                    Twall = 0;
                    Lwall = 0;
                    if(isTouching(Solidblock.class)){
                        move(-1);
                        Rwall = 1;
                    }
                    else{move(1);}
                }
            }
    }

    
    

    public void animation(){
        String[] Frontimages = {"PlayerF1.png","PlayerF2.png","PlayerF3.png","PlayerF4.png","PlayerF5.png","PlayerF6.png","PlayerF7.png","PlayerF8.png"};
        if(key == "s"){
            if(Fpiccounter == 8){
                Fpiccounter = 0;
            }
            else{
                setImage(Frontimages[Fpiccounter]);
                Fpiccounter = Fpiccounter + 1;
            }
        }
    }
    
    
    
  
    ///public Player(int lives, String newname){
       /// String name;
       /// int numLives;
       /// name  = newname;
       /// numLives = lives;
        
    ///}
    
}