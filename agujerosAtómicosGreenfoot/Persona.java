import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Persona creará objetos personas que aparecerán en la parte superior de la pantalla 
 * y bajarán 1 fila por turno, hasta eventualmente chocar contra un agujero negro. Si el agujero
 * está encendido, se termina la partida, caso contrario se elimina la persona.
 * 
 * Ignacio Mosconi
 * 07/10/23
 */
public class Persona extends Actor
{
    /**
     * ATRIBUTOS
     */
    private int posX;
    private int posY;
    private AgujeroNegro agujero;
    

    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
    
    }
    
    /**
     * MÉTODOS
     */
    
    //Movemos a Persona a cualquier parte del tablero
    public void setPos(int posX, int posY) {
        setLocation(posX, posY);
    }
    
    //Suponiendo que persona está ya ubicada en una posición de fila, la bajamos 100 pixeles en Y, lo que hace que baje una fila.
    public void bajarFila() {
        setLocation(getX(), getY()+100);
    }
    
}
