import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Mas1 extends Actor {
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
            String estadoAgujerosCadena = "";
            
            int[] estadoAgujeros = new int[4];
            
            //Generamos una colección con todos los objetos AgujerosNegros y obtenemos su estado, que cargamos
            //en el vector estadoAguejros, que guarda enteros. Con un acumulador completamos la cadena estadoAgujerosCadena.
            List<AgujeroNegro> agujeros = getWorld().getObjects(AgujeroNegro.class);
            for (AgujeroNegro agujero : agujeros) {
                //Obtenemos el estado y lo cargamos en el vector
                estadoAgujerosCadena = estadoAgujerosCadena + agujero.getEstado();
                contador++;
            }
            
            //Sumamos 1 a estadoAgujerosCadena y convertimos la suma a una cadena binaria
            int binario1 = Integer.parseInt(estadoAgujerosCadena, 2);
            int binario2 = Integer.parseInt("1", 2);
            int suma = binario1 + binario2;
            estadoAgujerosCadena = Integer.toBinaryString(suma);
            
            //Añadimos los ceros a la izquierda correspondientes
            String ceros = "000";
            estadoAgujerosCadena = ceros + estadoAgujerosCadena;
            //Invertimos la cadena, sacamos los 4 bits más significativos y volvemos a invertir.
            estadoAgujerosCadena = new StringBuilder(estadoAgujerosCadena).reverse().toString();
            estadoAgujerosCadena = estadoAgujerosCadena.substring(0,4);
            estadoAgujerosCadena = new StringBuilder(estadoAgujerosCadena).reverse().toString();
                    
            //Cargamos la cadena en el vector. 
            for (int i = 0; i < 4; i++) {
                estadoAgujeros[i] = Integer.valueOf(estadoAgujerosCadena.substring(i,i+1));
            }
            
            //Modificamos los agujeros negros según el vector, que es la suma +1 de la configuración actual.
            indice = 0;
            for (AgujeroNegro agujero : agujeros) {
                if ( estadoAgujeros[indice] == 1 ) {
                    agujero.establecerEstado(1);
                } else {
                    agujero.establecerEstado(0);
                }
                indice++;
            }        
            getWorld().removeObject(this);
        }
    }
}