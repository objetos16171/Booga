import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escudo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escudo extends Actor
{
    /**
     * Act - do whatever the Escudo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
