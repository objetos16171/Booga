import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        agrega();
    }
    
        /**
     * Agrega a los enemigos en la parte superior de la pantalla aleatoriamente
     */
    public void agrega()
    {
        addObject(new Enemigo(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(10));
        addObject(new Jugador(),300,300);
    }
}
