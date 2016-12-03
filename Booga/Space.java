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
    private Counter contPunt;
    private int contMuer;
    private Counter contnivel;//contador de puntos
    private SimpleTimer tiempo = new SimpleTimer();
    private SimpleTimer tiempo2 = new SimpleTimer();
    private SimpleTimer tiempo3 = new SimpleTimer();
    private SimpleTimer tiempo4 = new SimpleTimer();
    private Enemigo ene;
    private Boton Start, Salir, Help;
    private LinkedList <GreenfootImage> imagenes;
    private int l = 0; 
     private int ban = 0;
    private int jefe = 0;
    //contador de nivel
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
        //imagenes.add(new GreenfootImage("Creditos.jpg")); //4
        
        Start = new Boton(getImagen(1));
        Salir = new Boton(getImagen(2));
        Help = new Boton(getImagen(3));
        //Cre = new Boton(getImagen(4));
       menu();  
    }
    
    /**
     * Metodo que crea el menú del juego. 
     * Manda a llamar las imagenes de los botones y el del fondo
     */
    public void menu()
    {
        removeObjects(getObjects(null));
        addObject(Start, 110, 150);
        addObject(Help, 720, 400);
        Greenfoot.setSpeed(40);
        setBackground(getImagen(0));
    }
    
    /**
     * Metodo que crea la ayuda. La ayuda se manda a llamar
     * la imagen de ayuda y el boton de salir.
     */
    public void Help()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("Ayuda.png");
        setBackground(hp);
        addObject(Salir,740,450);  
    }
    
    /**
     * Método donde aparecen los creditos en una imagen
     */
    public void Creditos()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("Creditos.png");
        setBackground(hp);
        addObject(Salir,740,450);  
    }
     
    /**
     * Método que selecciona entre todos los botones que aparescan
     * en el juegoya sea el de salir que regresa al menú, el de start manda 
     * }al nivel 1, help manda a la ayuda y el boton de creditos.
     */
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(Salir)) {
            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(Start)) {
            removeObjects(getObjects(null));
            l = 1;
            nivel1();
        }
        /*if(Greenfoot.mouseClicked(Cre)){
            removeObjects(getObjects(null));
            Creditos();
        }*/
         if(Greenfoot.mouseClicked(Help)) {
            removeObjects(getObjects(null));
            Help();
        }
    }
    
    /**
     * Método del nivel uno del juego
     */
    public void nivel1()
    {
        setBackground("space1.jpg");
        addObject(new Enemigo(),Greenfoot.getRandomNumber(580), 40);
        addObject(new Jugador(),300,420);
        addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
        addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
        Greenfoot.setSpeed(45);
        
        agrega();
        
        //Greenfoot.playSound("Star_wars_Theme_Song.wav") 
        contVidas = new Counter("Vidas: "); //contadores 
        addObject(contVidas,68,480);
        contnivel = new Counter("Nivel: "); //contadores 
        addObject(contnivel,68,20);
        contVidas.setValue(3);
        contPunt = new Counter("Puntos: ");
        addObject(contPunt,640,480);
        contPunt.setValue(0);
    }
    
    /**
     * Método del nievel 2
     */
    public void nivel2()
    {
        ban=0;
        removeObjects(getObjects(null));
        setBackground("Fondo2.jpg");
        addObject(new Jugador(),300,420);
        Greenfoot.setSpeed(50);
        
        agrega();

        addObject(contVidas,68,480);
        contVidas.setValue(contVidas.getValue());
        addObject(contPunt,640,480);
        contPunt.setValue(contPunt.getValue());
        contnivel = new Counter("nivel: 2"); //contadores 
        addObject(contnivel,68,20);
    }
    
    /**
     * 
     */
    public void nivel3(){
        ban=0;
        removeObjects(getObjects(null));
        setBackground("Fondo3.jpg");
        addObject(new Jugador(),300,420);
        Greenfoot.setSpeed(55);
        if(ban==0){
        agrega();
        }
        addObject(contVidas,68,480);
        contVidas.setValue(contVidas.getValue());
        addObject(contPunt,640,480);
        contPunt.setValue(contPunt.getValue());
        contnivel = new Counter("nivel: 3"); //contadores 
        addObject(contnivel,68,20);
    }
    
    public void agrega()//se
    {
       if(ban==0){ 
        if(tiempo.millisElapsed() > 5000){
            addObject(new Enemigo(),Greenfoot.getRandomNumber(600), 40);
            
            addObject(new Moneda(),Greenfoot.getRandomNumber(600), 0);
            tiempo.mark();
         }
         else
            if(tiempo2.millisElapsed() > 10000){
                addObject(new Escudo(),Greenfoot.getRandomNumber(600), 0);
                tiempo2.mark();
            }
            if(tiempo3.millisElapsed() > 8000){
                addObject(new Meteorito(),Greenfoot.getRandomNumber(600), 0);
                 tiempo3.mark();
            }
            if(tiempo4.millisElapsed() > 20000){
                addObject(new Vida(),Greenfoot.getRandomNumber(600), 40);
                addObject(new Recarga(),Greenfoot.getRandomNumber(600), 0);
                 tiempo4.mark();
            }
       }  
    }

       
    public void jefe(int jefe)
    {
        ban=1;
        if(jefe == 1){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe1(),Greenfoot.getRandomNumber(480), 40);
           addObject(contVidas,68,480);
           contVidas.setValue(contVidas.getValue());
           addObject(contPunt,640,480);
           contPunt.setValue(contPunt.getValue());
           
        }
        if(jefe == 2){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe2(),Greenfoot.getRandomNumber(480), 40);
            addObject(contVidas,68,480);
            contVidas.setValue(contVidas.getValue());
            addObject(contPunt,640,480);
            contPunt.setValue(contPunt.getValue());
        
        }
        if(jefe == 3){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe3(),Greenfoot.getRandomNumber(480), 40);
            addObject(contVidas,68,480);
            contVidas.setValue(contVidas.getValue());
            addObject(contPunt,640,480);
            contPunt.setValue(contPunt.getValue());
        
        }
        if(tiempo3.millisElapsed() > 5000){
           addObject(new Escudo(),Greenfoot.getRandomNumber(600), 0);
           tiempo2.mark();
          }      
    }

     public void started()
    {
        tiempo.mark();
        tiempo2.mark();
    }
    
    public void act()
    {
        seleccionar();
        if(l == 1){
            agrega();
        }
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
    
    public void generaEscudo(int Bx, int By ) //Genera el escudo burbuja 
    {
        addObject(new EscudoBurbuja(),Bx,By);
    }
    
    public void remueveEscudo() //Remueve el escudo
    { 
        
    }
    
    public int getNumBalls() { return numBalas; }  //regresa el numero de balas
    
    public void newBalas(int Bx, int By)  //anade balas al esenario
   {
      numBalas--;
      if(numBalas>0){        // condicion capacidad de balas
        addObject(new Bala(), Bx, By);
      }
    }
    
   public void setBalas(int val){
       numBalas=val;
   }

   public void newBalljefe(int Ax, int Ay){
     addObject(new Balljefe(), Ax, Ay);
   }
    
  
   public void muerte()
   {
       decrementaVidas();
   }
   
   public void Gana(){
       removeObjects(getObjects(null));
       GreenfootImage gan = new GreenfootImage("Ganar.jpg");
       setBackground(gan);
       addObject(Salir,740,450);
    }
   
   /**
    * Metodo donde se decrementan las vidas del jugador.
    */
    public void decrementaVidas()  //Metodo para incrementar cont de vidas
    {
        contVidas.add(-1);
        if(contVidas.getValue() <= 0)
       {
           muere();
       }
    }
    public void muere()
    {
        removeObjects(getObjects(null));
        GreenfootImage pe = new GreenfootImage("Perdiste.jpg");
        setBackground(pe);
        addObject(Salir,740,450);
    }
    
    /**
     * Metodo para incrementar cont de puntos
     */
     public void incrmentaPuntos() 
    {
        contPunt.add(+1);
    }
    public void incrmentaVida() 
    {
        contVidas.add(+1);
    }
    
    public void cuentaEnemigos()
    {
        contMuer++;
    }
    
    public int getcuE()
    {
        return contMuer;
    }
}