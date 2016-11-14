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
    if(isTouching(Moneda.class))     // condicion para cuando toca un cuadro y y eliminarlo para despues cabiar su direccion en Y
       {
           removeTouching(Moneda.class);
       }// Add your action code here.
    }    
}
