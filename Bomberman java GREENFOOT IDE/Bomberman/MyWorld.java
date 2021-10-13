import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    String[] map = {
    "*******************", 
    "*P...BB...........*",
    "*B*.*B*.*.*.*.*.*.*",
    "*....B.......B....*",
    "*.*B*B*.*.*.*.*.*.*",
    "*.B..........B....*",
    "*.*.*.*.*.*B*B*.*.*",
    "*.......B.........*",
    "*.*.*B*.*.*.*.*B*.*",
    "*.....B........B..*",
    "*.*.*.*.*.*.*B*.*.*",
    "*.B.....BBBB......*",
    "*.*.*B*.*.*.*.*.*.*",
    "*..B...........B..*",
    "*******************",
    };

    String[] Xmap = {
    "*******************", 
    "*.................*",
    "*...............U.*",
    "*.................*",
    "*......U..........*",
    "*.................*",
    "*..............U..*",
    "*.................*",
    "*.....U...........*",
    "*...........U.....*",
    "*.................*",
    "*.................*",
    "*............U....*",
    "*.................*",
    "*******************",
    };

    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(180, 140, 5); 
        setPaintOrder(Player.class, Solidblock.class);
        setBackground("BackgroundFull.png");
        setUp(); 
        
    }
    
    private void setUp(){
        for(int i = 0; i < map.length; i++) {
            String mapY = map[i]; 
            for(int a = 0; a < mapY.length(); a++) {
                char mapChar = mapY.charAt(a); 
                int y = i * 10; 
                int x = a * 10;
                switch(mapChar){
                    case '*': 
                        addObject(new Solidblock(), x, y);
                        break; 
                    default: 
                        break; 
                    case 'P': 
                        addObject(new Player(), x, y);
                        break;
                    case 'B': 
                        addObject(new Breakblock(), x, y);
                        break;
                } 
            }
        }
        
        
        //for(int ii = 0; ii < Xmap.length; ii++) {
        //    String mapYY = Xmap[ii]; 
        //    for(int aa = 0; aa < mapYY.length(); aa++) {
        //        char mapChar = mapYY.charAt(aa); 
        //        int yy = ii * 10; 
        //        int xx = aa * 10;
        //        switch(mapChar){
          //          case 'U': 
        //              addObject(new Powerups(), xx, yy);
        //                break; 
        //            default: 
        //                break; 
        //            case 'P': 
        //                addObject(new Player(), xx, yy);
        //                break;
        //        } 
        //    }
        //}
    }
}
