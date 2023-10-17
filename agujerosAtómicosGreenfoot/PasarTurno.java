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
    private int contador = 0;
    private int estadoBotón = 1;
    private int rondasSobrevividas = 0;
    
    private ArrayList <String> filaEnemigos;
    private ArrayList <String> filaCohetes;
    private ArrayList <String> filaAgujeros;
    private ArrayList <String> filaCartas;

    /**
     * MÉTODO ACT - Es llamado cada vez que el botón Act o Run se presione en la ventana principal de Greenfoot.
     */
    public void act() {
        //Ejecutamos el código solamente si el botón es presionado 
        if (Greenfoot.mouseClicked(this) && (getEstadoBotón() == 1)) {
            //Cada vez que se presione el botón sumamos 1 a la cantidad de rondas sobrevividas.
            rondasSobrevividas++;
            getWorld().showText(String.valueOf(rondasSobrevividas),75,100);
            
            //Cada vez que se presiona el botón bajamos una fila a todos los objetos creados.
            bajarFilas();
            this.contador = this.contador + 1;
            
            //Si presionamos dos veces seguidas, queremos que el botón genere una fila de 
            //enemigos en la primera fila del tablero.
            if (contador == 2) {
                this.contador = 0;
                
                filaEnemigos.clear();
                filaCohetes.clear();
                filaAgujeros.clear();
                    
                generarFilaEnemigos(50);
            }
            
            //Cada vez que se preiosna el botón eliminamos las cartas anteriores y generamos una nueva tanda de cartas
            getWorld().removeObjects(getWorld().getObjects(And.class));
            getWorld().removeObjects(getWorld().getObjects(CarryDer.class));
            getWorld().removeObjects(getWorld().getObjects(CarryIzq.class));
            getWorld().removeObjects(getWorld().getObjects(Mas1.class));
            getWorld().removeObjects(getWorld().getObjects(Menos1.class));
            getWorld().removeObjects(getWorld().getObjects(Not.class));
            getWorld().removeObjects(getWorld().getObjects(Or.class));
            getWorld().removeObjects(getWorld().getObjects(Xor.class));
            
            generarFilaCartas(650);
        }
    }

    
    /**
     * MÉTODOS GET
     */
    
    public ArrayList <String> getFilaCohetes() {
        return this.filaCohetes;
    }
    
    public ArrayList <String> getFilaAgujerosNegros() {
        return this.filaAgujeros;
    }
    
    public int getEstadoBotón() {
        return this.estadoBotón;
    }
    
    
    /**
     * MÉTODOS VARIOS
     */
    
    public void cambiarEstadoBotón() { 
        if (getEstadoBotón() == 0) {
            this.estadoBotón = 1;
            setImage("botonPasar.png");
        } else {
            this.estadoBotón = 0;
            setImage("botonPasarDesHabilitado.png");
        }
    }
    
    //GENERACIÓN DE ENEMIGOS
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
    
    private void bajarFilas() {
        //Creamos listas que contengan todas las instancias actuales de objetos enemigos, y para cada una de ellas
        //(siempre y cuando no estén vacías (es decir, estos objetos existan), recorremos la lista para ejecutar 
        //el método bajarFila() de cada uno de estos objetos.
        List<Persona> personas = getWorld().getObjects(Persona.class);
        List<UFO> ufos = getWorld().getObjects(UFO.class);
        List<Vacía> vacias = getWorld().getObjects(Vacía.class);
        
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
                //BORRAMOS LA INSTANCIACIOŃ PARA QUE NO HAYA OBJETOS DE LA CLASE VACÍACOHETE, LO QUE NOS PERMITE TRABAJAR
                //CON LAS COMPUERTAS MÁS FÁCILMENTE.
                
                //VacíaCohete cartaVacía = new VacíaCohete();        
                //getWorld().addObject(cartaVacía, getColumna(i), 550);  
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
    
    //GENERACIÓN DE CARTAS
    public void generarFilaCartas(int fila) {
        //Creamos una nueva colección, donde colocaremos los nombres de las 3 cartas que irán en la fila.
        filaCartas = new ArrayList<String>();
        
        //Colocamos 4 cartas en una fila
        for (int i = 0; i < 3; i++) {
            random = greenfoot.Greenfoot.getRandomNumber(126);
            
            //Con un 17% de probabilidad, elegimos la carta NOT
            if (random <= 16) {
                filaCartas.add("NOT");
            //Con un 17% de probabilidad, elegimos la carta AND.
            } else if(random >=17 && random <=35) {
                filaCartas.add("AND");
            //Con un 17% de probabilidad, elegimos la carta OR.
            } else if(random >=36 && random <=54) {
                filaCartas.add("OR");
            //Con un 17% de probabilidad, elegimos la carta XOR.
            } else if(random >=55 && random <=73) {
                filaCartas.add("XOR");
            //Con un 9% de probabilidad, elegimos la carta Mas1.
            } else if(random >=74 && random <=92) {
                filaCartas.add("Mas1");
            //Con un 9% de probabilidad, elegimos la carta Menos1.
            } else if(random >=93 && random <=103) {
                filaCartas.add("Menos1");
            //Con un 9% de probabilidad, elegimos la carta OR.
            } else if(random >=104 && random <=114) {
                filaCartas.add("CarryIzq");
            //Con un 9% de probabilidad, elegimos la carta OR.
            } else if(random >=115 && random <=125) {
                filaCartas.add("CarryDer");
            }
        }
        //Una vez que generamos la colección, instanciamos los objetos.
        instanciarCartas(filaCartas,fila);        
    }
    
    private void instanciarCartas(ArrayList <String> filaCartas, int fila) {
        //El parámetro fila permite dterminar en qué número de fila deben instanciarse los objetos, 
        //en las columnas que se encuentran en las posiciones x 200, 300, 400 o 500 para esa 
        //  posición de Y de fila paasada como parámetro.
        
        //Recorremos la colección. Según lo que encontremos instanciamos
        for (int i = 0; i < 3; i++) {
            if (filaCartas.get(i) == "NOT") {
                Not cartaNot = new Not();     
                
                //Añadimos el objeto en la posición X, Y que corresponde. X la tenemos por el parámetro fila
                //e Y puede deducirse a través de la posición de la colección que estamos recorriendo
                getWorld().addObject(cartaNot, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "AND") {
                And cartaAnd = new And();        
                getWorld().addObject(cartaAnd, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "OR") {
                Or cartaOr = new Or();        
                getWorld().addObject(cartaOr, getColumnaCartas(i), fila);  
        
            }else if (filaCartas.get(i) == "OR") {
                Or cartaOr = new Or();        
                getWorld().addObject(cartaOr, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "XOR") {
                Xor cartaXor = new Xor();        
                getWorld().addObject(cartaXor, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "Mas1") {
                Mas1 cartaMas1 = new Mas1();        
                getWorld().addObject(cartaMas1, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "Menos1") {
                Menos1 cartaMenos1 = new Menos1();        
                getWorld().addObject(cartaMenos1, getColumnaCartas(i), fila);  
                
            }else if (filaCartas.get(i) == "CarryIzq") {
                CarryIzq cartaCarryIzq= new CarryIzq();        
                getWorld().addObject(cartaCarryIzq, getColumnaCartas(i), fila);
                
            }else if (filaCartas.get(i) == "CarryDer") {
                CarryDer cartaCarryDer = new CarryDer();        
                getWorld().addObject(cartaCarryDer, getColumnaCartas(i), fila);
            
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
    
    public int getColumnaCartas(int num) {
        //Recibimos un número entero que varía del 0 al 2 y en
        //base a él asignamos la posición en Y
        //correspondiente dentro del tablero. 
        
        //i=0 → y=230, i=1 → y=350, i=2 → y=468
        if (num == 0) {
            return 230;
        } else if (num == 1) {
            return 350;
        } else if (num == 2) {
            return 468;
        } else {
            //si num no varía entre 0 y 3, devolvemos la coordenada 0.
            return 0;
        }
    }
    
}