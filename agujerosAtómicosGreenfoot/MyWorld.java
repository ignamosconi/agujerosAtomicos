import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class MyWorld extends World
{
    private PasarTurno botonPasar;
    private int random;
    
    private ArrayList <String> filaCohetes;
    /**
     * Constructor para el tablero
     */
    public MyWorld() {    
        // Creamos un mundo de 700 x 700 pixeles, con celdas de 1x1 pixel.
        super(700, 700, 1); 

        //Establecemos el fondo a la imagen que colocamos en 
        setBackground("fondoTablero.png");
        
        //Creamos un objeto PasarTurno, que permite al jugador pasar su turno.
        PasarTurno botonPasar = new PasarTurno(); 
        addObject(botonPasar, 625, 600);
        
        //Utilizando los métodos del objeto PasarTurno, generamos dos filas de enemigos al inicializar el tablero.
        botonPasar.generarFilaEnemigos(50);
        botonPasar.generarFilaEnemigos(250);
        
        //Utilizando un método propio de Tablero, generamos una fila de cohetes y cartas vacías, con 50% de probabilidad cada una. 
        botonPasar.generarFilaCohetes();
        
        //Instanciamos 4 agujeros negros apagados en la fila y = 350
        botonPasar.generarFilaAgujerosNegros();
        
        //Generamos las cartas de poderes
        botonPasar.generarFilaCartas(650);
        
        //Creamos el encabezado de puntuación:
        showText("RONDAS",75,50);
        showText("SOBREVIVIDAS",75,75);
    }
}
