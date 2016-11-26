import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jefe1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe1 extends Enemigo
{
    /**
     * Act - do whatever the Jefe1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(1);
       super.movimiento();
    }    
}
