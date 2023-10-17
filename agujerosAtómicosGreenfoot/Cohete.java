import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Cohete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cohete extends Actor {
    
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        
    }
    
    //Movemos a Cohete a cualquier parte del tablero
    public void setPos(int posX, int posY) {
        setLocation(posX, posY);
    }
    
    public int getPosX() {
        return getX();
    }
    
    public int getPosY() {
        return getY();
    }
}