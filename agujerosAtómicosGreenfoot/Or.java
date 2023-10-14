import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Or extends Actor
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
            int contador = 0;
            int indice = 0;
            
            int[] estadoCohetes = new int[4]; 
            int[] estadoAgujeros = new int[4];
            
            //Llenamos el vector estadoCohetes
            //Si la lista está vacía, no hay un cohete, por lo que cargamos el valor 0. Sino, cargamos 1.
            
            //Chequeamos la existencia de objetos en las distintas coordenadas donde puede haber o no objetos.    
            if ( !((getWorld().getObjectsAt(200, 550, null) ).isEmpty()) ) {
                estadoCohetes[indice] = 1;
            } else {
                estadoCohetes[indice] = 0;
            }
            //Aumentamos el contador i para llenar la siguiente posición del vector estadoCohetes
            indice++;
            
            if ( !((getWorld().getObjectsAt(300, 550, null) ).isEmpty()) ) {
                estadoCohetes[indice] = 1;
            } else {
                estadoCohetes[indice] = 0;
            }
            indice++;
            
            if ( !((getWorld().getObjectsAt(400, 550, null) ).isEmpty()) ) {
                estadoCohetes[indice] = 1;
            } else {
                estadoCohetes[indice] = 0;
            }
            indice++;
        
            if ( !((getWorld().getObjectsAt(500, 550, null) ).isEmpty()) ) {
                estadoCohetes[indice] = 1;
            } else {
                estadoCohetes[indice] = 0;
            } 
            indice++;
    
            
            //Generamos una colección con todos los objetos AgujerosNegros y obtenemos su estado, que cargamos
            //en el vector estadoAguejros, que guarda enteros.
            List<AgujeroNegro> agujeros = getWorld().getObjects(AgujeroNegro.class);
            for (AgujeroNegro agujero : agujeros) {
                //Obtenemos el estado y lo cargamos en el vector
                estadoAgujeros[contador] = agujero.getEstado();
                contador++;
            }
            
            //Comparamos los elementos de estadoCohetes y estadoAgujeros y realizamos la operación  OR
            indice = 0;
            for (AgujeroNegro agujero : agujeros) {
                if ( (estadoCohetes[indice] == estadoAgujeros[indice]) && (estadoAgujeros[indice] == 0) ) {
                    //Si son iguales y son 0, apagamos el agujero negro. Caso contrario lo prendemos.
                    agujero.establecerEstado(0);
                } else {
                    agujero.establecerEstado(1);
                }
                
                indice++;
            }
            
            getWorld().removeObject(this);
        }
    }
}