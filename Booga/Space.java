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
    private Boton Start, Salir, Help, Cre;
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
        imagenes.add(new GreenfootImage("Creditos.png")); //4
        
        Start = new Boton(getImagen(1));
        Salir = new Boton(getImagen(2));
        Help = new Boton(getImagen(3));
        Cre = new Boton(getImagen(4));
       menu();  
    }
    
    /**
     * Metodo que crea el menú del juego. 
     * Manda a llamar las imagenes de los botones y el del fondo
     */
    public void menu()
    {
        removeObjects(getObjects(null));
        addObject(Start, 115, 210);
        addObject(Help, 720, 400);
        addObject(Cre, 370, 45);
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

        GreenfootImage hp = new GreenfootImage("ayuda.jpg");
        setBackground(hp);
        addObject(Salir,740,450);  
    }
    
    /**
     * Método donde aparecen los creditos en una imagen
     */
    public void Creditos()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("Creditos.jpeg");
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
         if(Greenfoot.mouseClicked(Help)) {
            removeObjects(getObjects(null));
            Help();
        }
        if(Greenfoot.mouseClicked(Cre)){
            removeObjects(getObjects(null));
            Creditos();
        }
    }
    public void contadores(){
        addObject(contVidas,68,480);
        contVidas.setValue(contVidas.getValue());
        addObject(contPunt,640,480);
        contPunt.setValue(contPunt.getValue());
        addObject(contnivel,68,20);
        contnivel.setValue(contnivel.getValue());
    }
    
    /**
     * Método del nivel uno del juego
     */
    public void nivel1()
    {
        ban=0;
        setBackground("space1.jpg");
        addObject(new Jugador(),300,420);
        Greenfoot.setSpeed(45);
        agrega();
        
        //Greenfoot.playSound("Star_wars_Theme_Song.wav") 
        contVidas = new Counter("Vidas: "); //contadores 
        addObject(contVidas,68,480);
        contnivel = new Counter("Nivel:"); //contadores 
        addObject(contnivel,68,20);
        contnivel.setValue(1);
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
        incrmentaNivel();
        addObject(new Jugador(),300,420);
        Greenfoot.setSpeed(50);
        
        agrega();
        contadores();
        /*addObject(contVidas,68,480);
        contVidas.setValue(contVidas.getValue());
        addObject(contPunt,640,480);
        contPunt.setValue(contPunt.getValue());
        addObject(contnivel,68,20);
        contnivel.setValue(contnivel.getValue());*/
    }
    
    /**
     * Método del nivel 3 del juego
     */
    public void nivel3(){
        ban=0;
        removeObjects(getObjects(null));
        setBackground("Fondo3.jpg");
        incrmentaNivel();
        addObject(new Jugador(),300,420);
        Greenfoot.setSpeed(55);
        if(ban==0){
        agrega();
        }
       contadores();
    }
    
    /**
     * Metodo que agrega a los enemigos, monedas, escudos, vidas,
     * meteo
     */
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

    /**
     * Metodo que agrega a los jefe dependiendo del nivel.
     */
    public void jefe(int jefe)
    {
        ban=1;
        if(jefe == 1){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe1(),Greenfoot.getRandomNumber(480), 40);
           contadores();
           
        }
        if(jefe == 2){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe2(),Greenfoot.getRandomNumber(480), 40);
            contadores();
        
        }
        if(jefe == 3){
            removeObjects(getObjects(null));
            addObject(new Jugador(),300,420);
            addObject(new Jefe3(),Greenfoot.getRandomNumber(480), 40);
            contadores();
        
        }
        if(tiempo3.millisElapsed() > 5000){
           addObject(new Escudo(),Greenfoot.getRandomNumber(600), 0);
           tiempo2.mark();
          }      
    }

    /**
     * Metodo que inicializa los tiempos.
     */
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
    
    /**
     * Metodo que regresa las imagenes en una lista.
     */
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
    
    /**
     * Metodos para regesar los botones
     */
    public Boton getJugar()
    {
        return Start;
    }
    public Boton getAyuda()
    {
        return Help;
    }
    
    /**
     * Metodo que agrega el escudo al jugador.
     */
    public void generaEscudo(int Bx, int By ) //Genera el escudo burbuja 
    {
        addObject(new EscudoBurbuja(),Bx,By);
    }
    
    public void remueveEscudo() //Remueve el escudo
    {     
    }
   
    /**
     * Metodo que regresa la cantidad de balas que tiene el jugador.
     */
   public int getNumBalls() { return numBalas; }  //regresa el numero de balas
   
   /**
    * Metodo que agrega una bala para el jugadoor.
    */
    public void newBalas(int Bx, int By)  //anade balas al esenario
   {
      numBalas--;
      if(numBalas>0){        // condicion capacidad de balas
        addObject(new Bala(), Bx, By);
      }
   }
    
  /**
   * Metodo que se iguala la cantidad de balas que tiene disponoble el jugador.
   */
  public void setBalas(int val){
       numBalas=val;
  }
   
  /**
  * Metodo que hañande una bala del jefe.
  */
   public void newBalljefe(int Ax, int Ay)
   {
     addObject(new Balljefe(), Ax, Ay);
   }
    
  /**
   * Metodo que se encarga de quitar una vida al jugador.
   */
   public void muerte()
   {
       decrementaVidas();
   }
   
   /**
    * Metodo que se encarga de poner la imagen de ganar cuando haya 
    * terminado el juego.
    */
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
    
    /**
     * Metodo que loca la imagen de perder cuando ya no tiene vidas
     */
    public void muere()
    {
        removeObjects(getObjects(null));
        ban=1;
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
    public void incrmentaNivel() 
    {
        contnivel.add(+1);
    }
    
    /**
     * Método que se encarga de sumar una vida al jugador
     */
    public void incrmentaVida() 
    {
        contVidas.add(+1);
    }
    
    /**
     * Método que se encarga de sumar a los enemigos
     */
    public void cuentaEnemigos()
    {
        contMuer++;
    }
    
    /**
     * Metodo que regresa la cantidad de muertes de los enemigos
     */
    public int getcuE()
    {
        return contMuer;
    }
}