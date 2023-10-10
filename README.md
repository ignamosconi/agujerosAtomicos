# Agujeros Atómicos - Trabajo Práctico MOON 1110011

Trabajo práctico desarrollado bajo la cátedra de **Paradigmas de programación** utilizando el software Greenfoot. 
<br>

**Profesores**
<ul>
  <li>Mario Rinaldi</li>
  <li>Matías Cassani</li>
</ul>

## Descripción del juego :green_book:

🛸 **Nombre del juego**: Agujeros Atómicos.
<br>
⏱️ **Duración de la partida**: 10 a 15 minutos.
<br>
👥 **Cantidad de jugadores**: Un jugador.

En "Agujeros Atómicos", el jugador debe evitar que hordas de UFOs ataquen un silo de reservas de bombas atómicas, cuidando de no acabar con civiles en el proceso. El objetivo del juego es sobrevivir a todas las hordas enemigas. El jugador podrá utilizar una sofisticada línea de defensa de agujeros negros, los cuales podrán ser activados utilizando compuertas lógicas.

## Elementos del juego 🎮

1. **Tablero**: 6 filas y 4 columnas, con la última fila tachada en rojo.
2. **Cartas**:
   - **Agujeros Negros**: 4 cartas
   - **Poder**: 12 cartas
     - 2 NOT
     - 2 AND
     - 2 OR
     - 2 XOR
     - 4 MISCELÁNEAS (sumar +1, restar -1, desfasaje un bit hacia la izquierda, desfase un bit hacia la derecha)
   - **Cohete**: 8 cartas
     - 4 vacías
     - 4 con un cohete
   - **Nave**: 24 cartas
     - 6 vacías
     - 6 personas dibujadas
     - 12 UFO dibujados

## Preparación del tablero :package:

El jugador debe seguir estos pasos para preparar el tablero:

1. Mezclar las cartas de cohete y colocar aleatoriamente 4 en la zona marcada en rojo (última fila del tablero).
2. Colocar las 4 cartas de agujeros negros en la quinta fila, con la cara vacía mirando hacia arriba.
3. Mezclar el mazo de naves y elegir aleatoriamente 8 cartas. Colocar 4 de ellas en la primera fila y las 4 restantes en la tercera fila.
4. Mezclar el mazo de cartas de poder y sacar aleatoriamente 3 cartas.

## Reglas y desarrollo de la partida 	:clipboard:

El jugador debe seguir estas reglas para jugar:

1. Utilizar las cartas de poder para activar y desactivar los agujeros negros.
2. Realizar diversas operaciones según las compuertas lógicas (NOT, AND, OR, XOR) con los cohetes y los agujeros negros para cambiar su configuración.
3. En cada turno, el jugador debe sacar 3 cartas de poder del mazo, pudiendo decidir si utilizarlas o no.
4. Realizar las operaciones deseadas y luego bajar una fila las naves en el tablero.
5. Después de esto, el jugador puede sacar 3 cartas nuevas del mazo de poder.
6. Resolver las situaciones que involucran las naves en la fila 5 según las reglas establecidas.
7. Recargar una nueva tanda de naves en la fila 1 después de resolver la situación de la fila 5.
8. El jugador ganará cuando se acaben las cartas del mazo de naves.
9. La partida puede ejecutarse indefinidamente si así lo desea el jugador, simplemente debe mezclar las cartas del mazo de descarte de naves y reponer el mazo principal una vez que este se agote.

<br>

¡Diviértete jugando "Agujeros Atómicos" y defiende el silo de bombas atómicas de las hordas de UFOs! 🚀

## Autores/Integrantes

<ul>
 <li>Lucarelli Bruno</li>
 <li>Mosconi Ignacio</li>
 <li>Terreno Valentino</li>
</ul>
