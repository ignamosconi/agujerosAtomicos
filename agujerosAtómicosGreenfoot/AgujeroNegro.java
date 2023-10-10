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
        //COLISIONES CON PERSONA
        
        //Si colisionamos con una persona y el agujero está encendido, terminamos el juego
        if ( isTouching(Persona.class) && (getEstado() == 1) ) {
            getWorld().removeObjects(getWorld().getObjects(PasarTurno.class));
            getWorld().showText("GAME OVER - CIVIL MUERTO",300,300);   
        
        //Si colisionamos con una persona y el agujero está apagado, la borramos.
        } else if ( isTouching(Persona.class) && (getEstado() == 0) ) {
            removeTouching(Persona.class);
        }
        
        
        //COLISIONES CON UFO
        
        //Si el agujero está encendido, borramos el UFO y cambiamos el estado del agujero.
        
        if ( isTouching(UFO.class) && (getEstado() == 1) ) {
            getWorld().removeObjects(getWorld().getObjects(UFO.class));
            cambiarEstado();
        
        //Si el agujero está apagado, lo bajamos a la siguiente fila para detectar colisiones con los cohetes
        } else if ( isTouching(UFO.class) && (getEstado() == 0) ) {
            //Bajamos 
        }
        
        
        
        //COLISIONES CON VACÍA
        
        //Borramos siempre los objetos de clase vacía, sin importar el estado del agujero negro.
        if ( isTouching(Vacía.class) ) {
            removeTouching(Vacía.class);
        }
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