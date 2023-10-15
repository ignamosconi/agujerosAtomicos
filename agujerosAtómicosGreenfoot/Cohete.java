import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Cohete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cohete extends Actor
{   
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        chequearColisión();
    }
    
    
    public void chequearColisión() {
        //Si detectamos una colisión entre ufo y cohete, eliminamos ambos.
        if ( isTouching(UFO.class) ) {
            removeTouching(UFO.class);
            getWorld().removeObject(this);
            
        //Si no hay colisión pero hay un ufo en la última fila, damos por perdido el juego.
        } else  {
            List<UFO> ufos = getWorld().getObjects(UFO.class);
            for (UFO ufo : ufos) {
                if (ufo.getPosY() == 550 ) {
                    getWorld().showText("GAME OVER - INVASIÓN NO DETENIDA", 300,300);
                    getWorld().removeObject(ufo); //Borramos la persona
                    getWorld().getObjects(PasarTurno.class).get(0).cambiarEstadoBotón(); //Deshabilitamos el botón
                }
            }
        }
    }
}