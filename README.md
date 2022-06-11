# Escapa del laberinto

Juego en el que se deberá escapar de un laberinto utilizando una cierta cantidad de oro, para realizar esto, el jugador deberá recorrer el laberinto en busca de oro, de esta manera juntar la cantidad necesaria y posteriormente poder escapar de él.

## ¿Cómo iniciar a jugar?

- Clonar el repositorio
- Abrir con el IDE preferido (Dado a que no hay un compilado .jar)
- Ejecutar
- Seleccionar en el menú la opción 'Opciones', posteriormente cargar mapa
- Seleccionar un mapa, existe uno por defecto dentro de la raíz del proyecto.
- Asignar un nombre
- Seleccionar en el menú la opción 'Nuevo juego', posteriormente seleccionar el mapa de los cargados

## Creación de mapas

En el juego se pueden crear nuestros propios mapas, para ello podremos utilizar un editor de texto cualquiera, y en él dibujar nuestro mapa, debido a que nuestro mapa tiene casillas que almacenan más información que solo el tipo que son, como las casillas de oro y de salida que además de su tipo almacenan la cantidad de oro que otorgan o que es necesaria para salir.

El formato para cargar un mapa es el siguiente: 
- \# para casillas que serán muros
- O para casillas que serán camino
- G para casillas que serán de oro
- S para casillas que serán salidas

Aunque tener en consideración que el archivo se encontrará con formato csv, por lo que para dibujar un mapa se deberá de ver aproximadamente así:

#,#,#,#,#,#,#,#,#,#  
#,O,O,O,G-2,O,O,O,O,S-2  
#,O,O,O,O,G-2,O,O,O,#  
#,O,G-3,O,O,O,O,O,O,#  
#,#,#,#,#,#,#,#,#,#  

Donde el - seguido de las casillas G y S, indica la cantidad de oro pra cada caso.
