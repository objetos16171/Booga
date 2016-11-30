import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscudoBurbuja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscudoBurbuja extends Actor
{
    /**
     * Act - do whatever the EscudoBurbuja wants to do. This method is called whenever
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
        // Add your action code here.
    }    
    
    public void Elimina() //Metodo para  que el escudo cubra al jugador
    {
        if(isTouching(Enemigo.class)){
            removeTouching(Enemigo.class);
        }
        
        if(isTouching(Meteorito.class)){
            removeTouching(Meteorito.class);
        }
        
        if(isTouching(Balljefe.class)){
            removeTouching(Enemigo.class);
        }
        
    } 
}