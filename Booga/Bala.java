import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Space mundo = (Space) getWorld();
       setLocation(getX(),getY()-4);
        
       if(isTouching(Meteorito.class)){
           removeTouching(Meteorito.class);
           mundo.incrmentaPuntos();
        }
        
       if(isTouching(Enemigo.class)){
           removeTouching(Enemigo.class);
           mundo.incrmentaPuntos();
        }
       
        // Add your action code here.
    }    
}
