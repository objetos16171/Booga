import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jefe1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jefe1 extends Enemigo
{
    public int velx=3;
    /**
     * Act - do whatever the Jefe1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Space mundo = (Space) getWorld();
        move(velx);
        dispara();
        movimiento();
    } 
    
    public void movimiento(){
    if(getX()==480){
        velx=-velx;
    }
    if(getX()==0){
        velx=-velx;
    }
   }
}

