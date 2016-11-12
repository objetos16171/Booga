import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteorito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteorito extends Actor
{
    /**
     * Act - do whatever the Meteorito wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.}
        movimiento();
    }
    
    public void movimiento()
    {
        setLocation(getX(), getY()+2);
    }
}
