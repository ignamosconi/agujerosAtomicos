import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/** 
 * Al presionar el botón pasar turno se terminará el turno del juegador, por lo que se renovarán sus cartas de poder y 
 * en caso de cumplirse la condición, se renovará una fila de enemigos. 
 * 
 * Las posiciones x e y de cada "fila" y "columna" dentro del tablero están especificadas en la documentación, en el título
 * "Definiendo límites del tablero".
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PasarTurno extends Actor {
    /**
     * ATRIBUTOS
     */
    //Las filas varían de 100 en 100, empiezan en 50 y termiann en 550.
    private int fila; 
    private int random;
    private int num;
    private int contador;
    
    private ArrayList <String> filaEnemigos;
    private ArrayList <String> filaCohetes;
    private ArrayList <String> filaAgujeros;
    private Persona cartaPersona;

    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        //Ejecutamos el código solamente si el botón es presionado 
        if (Greenfoot.mouseClicked(this)) {
            this.contador = this.contador + 1;
            
            //Cada vez que se presiona el botón bajamos una fila a todos los objetos creados.
            bajarFilas();
            
            //Si presionamos dos veces seguidas, queremos que el botón genere una fila de 
            //enemigos en la primera fila del tablero.
            if (contador == 2) {
                this.contador = 0;
                generarFilaEnemigos(50);
            }
        }
    }
    
    public void generarFilaEnemigos(int fila) {
        //Creamos una nueva colección, donde colocaremos los nombres de las 4 cartas que irán en la fila.
        filaEnemigos = new ArrayList<String>();
        
        //Colocamos 4 cartas en una fila
        for (int i = 0; i < 4; i++) {
            //De las cartas, un 50% debe ser UFOS, 25% debe ser personas y 25% debe ser vacío.
            random = greenfoot.Greenfoot.getRandomNumber(101);
            
            //Con un 50% de probabilidad, elegimos la carta UFO
            if (random <= 49) {
                filaEnemigos.add("UFO");
            
            //Con un 25% de probabilidad, elegimos Persona
            } else if(random >=50 && random <=74) {
                filaEnemigos.add("Persona");
            
            //Con un 25% de probabilidad, elegimos Vacía
            } else if (random >=75) {
                filaEnemigos.add("Vacía");
            }
        }
        //Una vez que generamos la colección, instanciamos los objetos.
        instanciarEnemigos(filaEnemigos,fila);        
    }
    
    private void instanciarEnemigos(ArrayList <String> filaEnemigos, int fila) {
        //El parámetro fila permite dterminar en qué número de fila deben instanciarse los objetos, 
        //en las columnas que se encuentran en las posiciones x 200, 300, 400 o 500 para esa 
        //  posición de Y de fila paasada como parámetro.
        
        //Recorremos la colección. Según lo que encontremos instanciamos
        for (int i = 0; i < 4; i++) {
            if (filaEnemigos.get(i) == "UFO") {
                UFO cartaUFO = new UFO();     
                
                //Añadimos el objeto en la posición X, Y que corresponde. X la tenemos por el parámetro fila
                //e Y puede deducirse a través de la posición de la colección que estamos recorriendo
                getWorld().addObject(cartaUFO, getColumna(i), fila);
                
            }else if (filaEnemigos.get(i) == "Persona") {
                Persona cartaPersona = new Persona();        
                getWorld().addObject(cartaPersona, getColumna(i), fila);
                
            }else if (filaEnemigos.get(i) == "Vacía") {
                Vacía cartaVacía = new Vacía();        
                getWorld().addObject(cartaVacía, getColumna(i), fila);  
            }
        }
    }
    
    public int getColumna(int num) {
        //Recibimos un número entero que varía del 0 al 3 y en
        //base a él asignamos la posición en Y
        //correspondiente dentro del tablero. 
        
        //i=0 → y=200, i=1 → y=300, i=2 → y=400, i=3 → y=500
        if (num == 0) {
            return 200;
        } else if (num == 1) {
            return 300;
        } else if (num == 2) {
            return 400;
        } else if (num == 3) {
            return 500;
        } else {
            //si num no varía entre 0 y 3, devolvemos la coordenada 0.
            return 0;
        }
    }
    
    private void bajarFilas() {
        //Creamos listas que contengan todas las instancias actuales de objetos enemigos, y para cada una de ellas
        //(siempre y cuando no estén vacías (es decir, estos objetos existan), recorremos la lista para ejecutar 
        //el método bajarFila() de cada uno de estos objetos.
        
        List<Persona> personas = getWorld().getObjects(Persona.class);
        List<UFO> ufos = getWorld().getObjects(UFO.class);
        List<Vacía> vacias = getWorld().getObjects(Vacía.class);
        
        if ((personas != null && !personas.isEmpty()) && (ufos != null && !ufos.isEmpty()) && (vacias != null && !vacias.isEmpty())) 
        {
            for (Persona persona : personas) {
                persona.bajarFila();
            }
            
            for (UFO ufo : ufos) {
                ufo.bajarFila();
            }
            
            for (Vacía vacia : vacias) {
                vacia.bajarFila();
            }
        }
        
    }
    
    
    //GENERACIÓN DE COHETES
    public void generarFilaCohetes() {
        //Creamos una nueva colección, donde colocaremos los nombres de las 4 cartas que irán en la fila.
        filaCohetes = new ArrayList<String>();
        
        //Colocamos 4 cartas en una fila
        for (int i = 0; i < 4; i++) {
            //De las cartas, un 50% debe ser UFOS, 25% debe ser personas y 25% debe ser vacío.
            random = greenfoot.Greenfoot.getRandomNumber(2);
            
            //Con un 50% de probabilidad, elegimos la carta Cohete
            if (random == 0) {
                filaCohetes.add("Cohete");

            //Con un 50% de probabilidad, elegimos Vacía
            } else if (random == 1) {
                filaCohetes.add("Vacía");
            }
        }
        //Una vez que generamos la colección, instanciamos los objetos.
        instanciarCohetes(filaCohetes);        
    }
    
    private void instanciarCohetes(ArrayList <String> filaCohetes) {
        //Generaremos los cohetes siempre en la posición Y = 550.
        // La posición x de cada objeto se obtienen con el método getColumna de la clase PasarTurno. 
        
        //Recorremos la colección. Según lo que encontremos instanciamos
        for (int i = 0; i < 4; i++) {
            if (filaCohetes.get(i) == "Cohete") {
                Cohete cartaCohete = new Cohete();     
                
                //Añadimos el objeto en la posición X, Y que corresponde. X la tenemos por el parámetro fila
                //e Y puede deducirse a través de la posición de la colección que estamos recorriendo
                getWorld().addObject(cartaCohete, getColumna(i), 550);
                
            } else if (filaCohetes.get(i) == "Vacía") {
                VacíaCohete cartaVacía = new VacíaCohete();        
                getWorld().addObject(cartaVacía, getColumna(i), 550);  
            }
        }
    }
    
    //GENERACIÓN DE AGUJEROS NEGROS
    public void generarFilaAgujerosNegros() {
        //Creamos una nueva colección, donde colocaremos los nombres de las 4 cartas que irán en la fila.
        filaAgujeros = new ArrayList<String>();
        
        for (int i = 0; i < 4; i++) {
            AgujeroNegro cartaAgujeroNegro = new AgujeroNegro();     
                
            getWorld().addObject(cartaAgujeroNegro, getColumna(i), 450);
        }
    }
    
}