<<<<<<< HEAD
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
       move(1);
       movimiento();
    }    
    
    public void movimiento()
    {
        Space mundo = (Space) getWorld();
        setLocation(getX(), getY()+2);
        if(getX() > 640 || getY() > 498){
            mundo.removeObject(this);
        }
        
        
    } 
}
=======
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer tiempo = new SimpleTimer();
    public void act() 
    {
        // Add your action code here.
       move(2);
       movimiento();
    }    
    
    public void movimiento()
    {
        Space mundo = (Space) getWorld();
        setLocation(getX(), getY()+2);
        if(getX() > 640 || getY() > 498){
            mundo.removeObject(this);
        }
        
        
    } 
    public void dispara(){
     Space mundo = (Space) getWorld();
    if(tiempo.millisElapsed() > 5000){
    mundo.newBalljefe(getX(),getY()+20); 
    tiempo.mark();
           
}
}
}
>>>>>>> origin/master
