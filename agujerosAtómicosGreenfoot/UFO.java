import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UFO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UFO extends Actor
{
    /**
     * ATRIBUTOS
     */
    private int posX;
    private int posY;
    

    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        getWorld().showText("Posición X:"+getX(),100,20);
        getWorld().showText("Posición Y:"+getY(),450,20);
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
