import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    private int esc=0;
    private int escudo=0;
    private Counter contTiempo;
    private SimpleTimer tiempo3 = new SimpleTimer();
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
           mundo.incrmentaPuntos();
        }
        if(isTouching(Recarga.class)){
           mundo.setBalas(100);
           removeTouching(Recarga.class);
        }
        if(isTouching(Meteorito.class)){
           removeTouching(Meteorito.class);
           if(esc==0){
           mundo.muerte();
          }
        }else
        if(isTouching(Enemigo.class)){
           removeTouching(Enemigo.class);
            if(esc==0){
           mundo.muerte();
          }
        }
        else
        if(isTouching(Balljefe.class)){
           removeTouching(Balljefe.class);
            if(esc==0){
           mundo.muerte();
          }
        }
        else
        if(isTouching(Escudo.class)) //condicion para creacion del escudo
        {  
               esc=1;
               removeTouching(Escudo.class);
               mundo.generaEscudo(getX(), getY());
   
        } if(tiempo3.millisElapsed() > 10000){
            esc=0;
            tiempo3.mark();
         }
        
              
            if(Greenfoot.isKeyDown("s")){ //Condicio para creacion de balas
                if(Greenfoot.getRandomNumber(100) > 75)
                {
                 mundo.newBalas(getX()+8,getY()-40);
                 mundo.newBalas(getX()-42,getY()-40);
                }
        }
    } 
}    

