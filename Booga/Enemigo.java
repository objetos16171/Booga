import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    private LinkedList <GreenfootImage> imagenes;
    private int lv = 0;
    private int vida = 1;
    private SimpleTimer tiempo = new SimpleTimer();
    /**
     * Constructor del enemigo
     */
    public Enemigo()
    {
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("Jefe1.jpg"));      //0
        imagenes.add(new GreenfootImage("Enemigo2.jpg")); 
    }
    
    public void act() 
    {
        // Add your action code here.
       movimiento();
       if(lv==1)
       {
           getImagen(0);
        }
        if(lv==1)
       {
           getImagen(1);
        }
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
 
    public void setNivel(int lvl)
    {
        lv=lvl;
    }
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
}

