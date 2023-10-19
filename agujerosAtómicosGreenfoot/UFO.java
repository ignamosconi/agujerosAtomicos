import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

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
    
    private int bandera = 0;
    
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {

    }
    
    /**
     * MÉTODOS
     */
    
    //Chequeamos colisiones con cohetes.
    public void chequearColisión() {
        //Si el ufo está tocando a un cohete, lo borramos a él y al cohete
        if (isTouching(Cohete.class)) {
            removeTouching(Cohete.class);
            setImage("empty.png"); //hacemos invisible al ufo
            setPos(1000,1000); // enviamos al ufo fuera del tablero (si hacemos removeObject.this crashea pq se tiene que usar después)
        }   
        
        //Si el ufo NO está tocando un cohete, y está en la última fila, significa que perdimos el juego.
        if (isTouching(Cohete.class) == false && getPosY() == 550) {
            getWorld().showText("GAME OVER - INVASIÓN NO DETENIDA", 300,300);
            getWorld().getObjects(PasarTurno.class).get(0).cambiarEstadoBotón(); //Deshabilitamos el botón   
        }
    }
    
    //Movemos a UFO a cualquier parte del tablero
    public void setPos(int posX, int posY) {
        setLocation(posX, posY);
    }
    
    public int getPosX() {
        return getX();
    }
    
    public int getPosY() {
        return getY();
    }
    
    //Suponiendo que persona está ya ubicada en una posición de fila, la bajamos 100 pixeles en Y, lo que hace que baje una fila.
    public void bajarFila() {
        setLocation(getX(), getY()+100);
    }
}
