import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class AgujeroNegro extends Actor
{
    /**
     * ATRIBUTOS
     */
    private int estado = 0;
    private UFO ufos;
    
    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        
        //Ejecutamos act siempre y cuando el botón esté habilitado
        if ( getWorld().getObjects(PasarTurno.class).get(0).getEstadoBotón() == 1 ) {
            //Si estamos colisionando con una persona, y está activado el agujero, terminamos el juego.
            //Si estamos colisionando con una persona pero no está activado el agujero, la eliminamos
            if ( (isTouching(Persona.class)) && getEstado() == 1 ) {
                getWorld().showText("GAME OVER - CIVIL MUERTO", 300,300);
                getWorld().removeObject(getWorld().getObjects(Persona.class).get(0)); //Borramos la persona
                getWorld().getObjects(PasarTurno.class).get(0).cambiarEstadoBotón(); //Deshabilitamos el botón
                
            } else if (isTouching(Persona.class) && getEstado() == 0) {
                getWorld().removeObject(getWorld().getObjects(Persona.class).get(0)); //Borramos la persona
            }
            
            //Si estamos colisionando con un UFO, y está activado el agujero, lo eliminamos.
            if (isTouching(UFO.class) && getEstado() == 1 ) {
                removeTouching(UFO.class); //Borramos el UFO
                cambiarEstado(); //Apagamos el agujero negro    
            } 
            
            //Si estamos colisionando con un UFO y está desactivado el agujero, perdemos el juego.
            if ((isTouching(UFO.class) && getEstado() == 0)) {
                getWorld().showText("GAME OVER - INVASIÓN NO DETENIDA", 350,300);
                getWorld().removeObject(getWorld().getObjects(UFO.class).get(0)); //Borramos los UFOS
                getWorld().getObjects(PasarTurno.class).get(0).cambiarEstadoBotón(); //Deshabilitamos el botón
            }
        }        
    }

    
    public void cambiarEstado() {
        if (getEstado() == 0) {
            this.estado = 1;
            setImage("agujeroNegro.png");
        }  else {
            this.estado = 0;
            setImage("Carta.png");
        }
    }
    
    public int getEstado() { return this.estado; }
    
    public void establecerEstado(int estado) {
        
        if (estado == 1) {
            this.estado = estado;
            setImage("agujeroNegro.png");
        } else {
            this.estado = estado;
            setImage("Carta.png");
        }
    }
}