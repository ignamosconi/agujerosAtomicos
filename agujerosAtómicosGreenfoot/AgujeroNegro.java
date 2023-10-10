    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AgujeroNegro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AgujeroNegro extends Actor
{
    /**
     * ATRIBUTOS
     */
    private int estado = 0;
    
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        // Add your action code here.
    }
    
    public void cambiarEstado() {
        if (estado == 0) {
            this.estado = 1;
            setImage("agujeroNegro.png");
        }  else {
            this.estado = 0;
            setImage("Carta.png");
        }
    }
    
    public int getEstado() {
        return this.estado;
    }
    
        
        
    
}