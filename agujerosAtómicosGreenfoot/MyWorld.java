import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    /**
     * Constructor para el tablero
     */
    public MyWorld() {    
        // Creamos un mundo de 700 x 700 pixeles, con celdas de 1x1 pixel.
        super(700, 700, 1); 

        //Establecemos el fondo a la imagen que colocamos en 
        setBackground("fondoTablero.png");
        
        
        //Elegimos aleatoriamente 8 cartas del tipo Persona, UFO y Vacía y las colocamos entre la 1er y 3ra fila
        
        
        
    }
}
