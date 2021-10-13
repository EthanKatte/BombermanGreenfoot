import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.ThreadLocalRandom;

/***
 * Write a description of class Creep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creep extends Movers
{
    int Movecounter = 0; //initializing variables
    int randomvalue = ThreadLocalRandom.current().nextInt(0, 4);//Sets the first direction
    int No_up = 0;//The enemy can go in this direction if it == 0
    int No_down = 0;//The enemy can go in this direction if it == 0
    int No_left = 0;//The enemy can go in this direction if it == 0
    int No_right = 0;//The enemy can go in this direction if it == 0
    /**
     * Act - do whatever the Creep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(getX() == 10){//Sets the directions the player can go in the far left column
           if(getY() == 10){//Sets the directions the player can go in the top left corner
               No_left = 1;//Cannot go left
               No_up = 1;//Cannot go up
               while((randomvalue == 0) || (randomvalue == 2)){// Makes it so you will definately go an available direction
                            randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
               }
           }
           if(getY() == 130){//Sets the directions the player can go in the bottom left corner
              No_left = 1;//Cannot go left
              No_down = 1;//Cannot go down
              while((randomvalue == 3) || (randomvalue == 2)){// Makes it so you will definately go an available direction
                            randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
               }
           }
           No_left = 1;//Cannot go left
           while(randomvalue == 0){// Makes it so you will definately go an available direction
              randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
           }
       }
       if(getX() == 170){//Sets the directions the player can go in the far right column
           if(getY() == 10){//Sets the directions the player can go in the top right corner
               No_right = 1;//Cannot go right
               No_up = 1;//Cannot go up
               while((randomvalue == 0) || (randomvalue == 1)){// Makes it so you will definately go an available direction
                            randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
               }
           }
           if(getY() == 130){//Sets the directions the player can go in the bottom right corner
               No_right = 1;//Cannot go right
               No_down = 1;//Cannot go down
               while((randomvalue == 3) || (randomvalue == 1)){// Makes it so you will definately go an available direction
                            randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
               }
           }
           No_right = 1;//Cannot go right
           while(randomvalue == 1){// Makes it so you will definately go an available direction
              randomvalue = ThreadLocalRandom.current().nextInt(0, 4);
           }
       }
       if(getY() == 130){//Sets the directions the player can go at the bottom row (but not in either corner)
           while(randomvalue == 3){
              randomvalue = ThreadLocalRandom.current().nextInt(0, 4);// Makes it so you will definately go an available direction
           }

       }
       if(getY() == 10){//Sets the directions the player can go at the top row (but not in either corner)
           while(randomvalue == 2){
              randomvalue = ThreadLocalRandom.current().nextInt(0, 4);// Makes it so you will definately go an available direction
           }

       }
   
       if (Movecounter < 10) { //Makes the enemy move 1 whole block
           if(No_up == 0){ //Makes sure that 'up' is an available direction
               if(randomvalue == 2){//is 'up' the random direction
                   if(isTouching(Breakblock.class)){//what to do if the enemy hits a breakable block
                       setLocation(getX(), getY()+2);//sets the enemies location back to before hitting the breakable block
                       Movecounter = 10; //resets move counter
                   }
                    
                   else{
                       setLocation(getX(), getY()-1);//move
                       Movecounter = Movecounter + 1;//every '1' here counts as 10% of a block, this just counts how close it is to a full block
                   }
               }//UP
           }
           if(No_down == 0){//Makes sure that 'down' is an available direction
               if(randomvalue == 3){//is 'down' the random direction
                   if(isTouching(Breakblock.class)){//what to do if the enemy hits a breakable block
                       setLocation(getX(), getY()-2);//sets the enemies location back to before hitting the breakable block
                       Movecounter = 10;//resets move counter
                   }
                   else{
                       setLocation(getX(), getY()+1);//move
                       Movecounter = Movecounter + 1;//every '1' here counts as 10% of a block, this just counts how close it is to a full block
                   }
               }//DOWN
           }
           if(No_left == 0){//Makes sure that 'left' is an available direction
               if(randomvalue == 0){//is 'left' the random direction
                   if(isTouching(Breakblock.class)){//what to do if the enemy hits a breakable block
                      setLocation(getX()+2, getY());//sets the enemies location back to before hitting the breakable block
                      Movecounter = 10;//resets move counter
                   }
                   else{
                       setLocation(getX()-1, getY());//move
                       Movecounter = Movecounter + 1;//every '1' here counts as 10% of a block, this just counts how close it is to a full block
                   }
               }//LEFT
           }
           if(No_right == 0){//Makes sure that 'right' is an available direction
               if(randomvalue == 1){//is 'right' the random direction
                   if(isTouching(Breakblock.class)){//what to do if the enemy hits a breakable block
                       setLocation(getX()-2, getY());//sets the enemies location back to before hitting the breakable block
                       Movecounter = 10;//resets move counter
                   }
                   else{
                        setLocation(getX()+1, getY());//move
                        Movecounter = Movecounter + 1;//every '1' here counts as 10% of a block, this just counts how close it is to a full block
                    }
                }//RIGHT
            }
            
        }
        else{
           //Greenfoot.stop();
           Movecounter = 0;//resets the move counter
           randomvalue = ThreadLocalRandom.current().nextInt(0, 4);//Gets the random direction
           if((getY()/2)%10 != 0){
               if((getX()/2)%10 != 0){
                    No_up = 0; //You can go this direction
                    No_down = 0;//You can go this direction
                    No_left = 0;//You can go this direction
                    No_right = 0;//You can go this direction
                    
               }
               else{
                    No_up = 1;//You can't go this direction
                    No_down = 1;//You can't go this direction
                    No_left = 0;//You can go this direction
                    No_right = 0;//You can go this direction
                    while((randomvalue == 3) || (randomvalue == 2)){
                        randomvalue = ThreadLocalRandom.current().nextInt(0, 4);// Makes it so you will definately go an available direction
                    }
               }

            }
            else{
                if((getX()/2)%10 != 0){
                    No_left = 1;//You can't go this direction
                    No_right = 1;//You can't go this direction
                    No_up = 0;//You can go this direction
                    No_down = 0;//You can go this direction
                    while((randomvalue == 0) || (randomvalue == 1)){
                        randomvalue = ThreadLocalRandom.current().nextInt(0, 4);// Makes it so you will definately go an available direction
                    }
                }
            }
            //System.out.println(randomvalue)
       }
       animation();
    }
    int Fpiccounter = 0;
    public void animation(){
        String[] Frontimages = {"CreepF1.png","CreepF2.png","CreepF3.png","CreepF4.png","CreepF5.png","CreepF6.png"};
        
        if(Fpiccounter == 6){
                Fpiccounter = 0;
            }
            else{
                setImage(Frontimages[Fpiccounter]);
                Fpiccounter = Fpiccounter + 1;
            }
    }
}
//YEET 