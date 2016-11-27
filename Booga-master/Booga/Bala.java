import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int eliminados=0;
    public void act() 
    {
       setLocation(getX(),getY()-4);
       movimiento();
    }
    public void movimiento()
    {
        Space mundo = (Space) getWorld();
         if(isTouching(Meteorito.class)){
           removeTouching(Meteorito.class);
           mundo.incrmentaPuntos();
        }
        
       if(isTouching(Enemigo.class)){
           removeTouching(Enemigo.class);
           mundo.incrmentaPuntos();
           eliminados++;
           
           if(eliminados==1){
             
             mundo.agrega(1);
           }
       }
     }
}
