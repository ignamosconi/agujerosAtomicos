import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Not extends Actor
{
    /**
     * ATRIBUTOS
     */
    private AgujeroNegro agujeros;
    
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            //Creamos una lista con todos los objetos Agujeros negro del mundo
            List<AgujeroNegro> agujeros = getWorld().getObjects(AgujeroNegro.class);
        
            //Cambiamos el estado de todos los objetos
            for (AgujeroNegro agujero : agujeros) {
                agujero.cambiarEstado();
            }
            
            //Eliminamos la carta después de usarse
            getWorld().removeObject(this);
        }
    }
}
