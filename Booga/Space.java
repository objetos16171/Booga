import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private SimpleTimer tiempo = new SimpleTimer();
    private Enemigo ene;
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
        addObject(new Enemigo(),Greenfoot.getRandomNumber(580), 40);
        addObject(new Jugador(),300,420);
        addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
        addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
       //Greenfoot.playSound("Star_wars_Theme_Song.wav");
    }
    
    public void started()
    {
        tiempo.mark();
    }
       
    public void act()
    {
        if(tiempo.millisElapsed() > 3000){
            addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
            addObject(new Enemigo(),Greenfoot.getRandomNumber(600), 40);
            addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
            tiempo.mark();
        }
    } 
}
