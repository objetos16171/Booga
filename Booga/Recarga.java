import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recarga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class recarga extends Actor
{
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
        if(getY() > 498)//Condicion para choque de meteorito con jugador
            {
                mundo.removeObject(this);
            } 
    }
}