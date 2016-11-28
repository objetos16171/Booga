import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balljefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balljefe extends Actor
{
    /**
     * Act - do whatever the Balljefe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
    {
        // Add your action code here.
        setLocation(getX(),getY()+2);
        movimiento();
    }
    
    public void movimiento()
    {
        Space mundo = (Space) getWorld();
        setLocation(getX(), getY());
        if(getY() > 498){
            mundo.removeObject(this);
        }
        
    }  
}

