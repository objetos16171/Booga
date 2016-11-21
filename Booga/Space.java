import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
     private int numBalas = 100;  //numero de balas
    private Counter contTiempo;  //contador de tiemp
    private Counter contVidas;   //conntador de vidas
    private Counter contPunt;    //contador de puntos
    private SimpleTimer tiempo = new SimpleTimer();
    private Enemigo ene;
    private Boton Start, Salir, Help;
    private LinkedList <GreenfootImage> imagenes;
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1);
         imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("menu.jpg"));      //0
        imagenes.add(new GreenfootImage("Start.png")); //1
        imagenes.add(new GreenfootImage("Salir.png"));//2
        imagenes.add(new GreenfootImage("Help.png")); //3
        
        contVidas = new Counter("Vidas: "); //contadores 
        addObject(contVidas,68,480);
        contVidas.setValue(3);
        contPunt = new Counter("Puntos: ");
        addObject(contPunt,640,480);
        contPunt.setValue(0);               //contadores
        
        Start = new Boton(getImagen(1));
        Salir = new Boton(getImagen(2));
        Help = new Boton(getImagen(3));
       
        menu();
    }
    
    public void menu()
    {
        removeObjects(getObjects(null));
        setBackground(getImagen(0));
        addObject(Start, 200, 100);
        addObject(Help, 400, 100);
        Greenfoot.setSpeed(40);

    }
    
    public void Help()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("Ayuda.png");
        setBackground(hp);
        addObject(Salir,100,50);  
    }
    
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(Salir)) {
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(Start)) {
            removeObjects(getObjects(null));
            nivel1();
        }
         if(Greenfoot.mouseClicked(Help)) {
            removeObjects(getObjects(null));
            Help();
        }
    }
    
    public void nivel1()
    {
       addObject(new Enemigo(),Greenfoot.getRandomNumber(580), 40);
        addObject(new Jugador(),300,420);
        addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
        addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
        //Greenfoot.playSound("Star_wars_Theme_Song.wav")
        agrega();

    }
    
    public void agrega()
    {
         if(tiempo.millisElapsed() > 3000){
            addObject(new Enemigo(),Greenfoot.getRandomNumber(600), 40);
            addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
            addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
            tiempo.mark();
        }
    }
    
     public void started()
    {
        tiempo.mark();
    }
    
    public void act()
    {
        seleccionar();
    } 
    
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    public Boton getJugar()
    {
        return Start;
    }
    
    public Boton getAyuda()
    {
        return Help;
    }
    
    public int getNumBalls() { return numBalas; }  //regresa el numero de balas
    
    public void newBalas(int Bx, int By)  //anade balas al esenario
   {
      numBalas--;
      addObject(new Bala(), Bx, By);
    }
    
    public void decrementaVidas()  //Metodo para incrementar cont de vidas
    {
        contVidas.add(-1);
    }
    
     public void incrmentaPuntos() //Metodo para incrementar cont de puntos
    {
        contPunt.add(+1);
    }
}

