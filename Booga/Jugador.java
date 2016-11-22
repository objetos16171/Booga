import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         Space mundo = (Space) getWorld();
        setLocation(getX(), getY());  //Locacion de la nave
        
        if(Greenfoot.isKeyDown("left")){
            move(-3);
        }
        if(Greenfoot.isKeyDown("right")){
            move(3);
        }    
        if(Greenfoot.isKeyDown("up")&& getY()>300){
            setLocation(getX(),getY()-3);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+3);
        }
        if(isTouching(Moneda.class)){
           removeTouching(Moneda.class);
        }
        if(isTouching(Meteorito.class)){
           removeTouching(Meteorito.class);
        }
        
        if(Greenfoot.isKeyDown("s")){ //Condicio para creacion de balas
            mundo.newBalas(getX()+8,getY()-40);
            mundo.newBalas(getX()-42,getY()-40);
        }
    }    
}
