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
    private int v1 = 0;
    public void act() 
    {
       setLocation(getX(),getY()-4);
       movimiento();
    }
    
    public void movimiento()
    {

        Space mundo = (Space) getWorld();
        mundo.getcuE();
        if(getY()==0)
        {
           setLocation(800,getY());
        }
        if(isTouching(Meteorito.class)){
           removeTouching(Meteorito.class);
           mundo.incrmentaPuntos();
        }
        
        if(isTouching(Jefe1.class)){
            v1+=1;
            if(v1 > 15){
            removeTouching(Jefe1.class);
            mundo.nivel2();
           }
        }else
           if(isTouching(Jefe2.class)){
           removeTouching(Jefe2.class);
           mundo.nivel3();
        }
        else
        if(isTouching(Jefe3.class)){
           removeTouching(Jefe3.class);
           mundo.Gana();
        }else
        if(isTouching(Enemigo.class)){
            mundo.cuentaEnemigos();
           removeTouching(Enemigo.class);
           mundo.incrmentaPuntos();
           if(mundo.getcuE()== 2){
               mundo.jefe(1);
           }else
           if(mundo.getcuE()== 4){
               mundo.jefe(2);
           }
           else
           if(mundo.getcuE()== 6){
               mundo.jefe(3);
           }
        }
   }    
}
     
    