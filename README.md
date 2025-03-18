# DAA-P4-Programacion-Dinamica
Repositorio para la Práctica 4 Diseño y Análisis de Algoritmos - Experimentación con Programación Dinámica
- **@Autor:** *Himar Edhey Hernández Alonso*
- **@Autor:** *Aarón Jano Barreto*

# Descripción de la práctica
## Imlementación
- Uso de Herencia (No es estrictamente necesario patrón estrategia, ni plantilla, etc.) -> el que más se adecue.
- Implementar 3 algoritmos.
  - **Fuerza Bruta:**
  - **Voraz:** Es ciego, es rápido pero no da siempre la solución óptima.
  - **Programación Dinámica:** Implementar un algoritmo (Buscar en Internet, ChatGPT, lo que sea).
- Los grafos se leen desde ficheros:
```ejemplo_grafo:
4
A B 25
A C 10
A D 15
B C 10
B D 45
C D 5
```
- Requiere:
  - Función Objetivo.
  - Tiempo de ejecución.
- Comparar los 3 algoritmos (los valores del pdf son inventados, pero es más o menos los pesos que deberían tener cada algoritmo respecto a los otros).
- Para agilizar la ejecución de los algoritmos (sobretodo fuerza bruta que puede pasar horas) damos un límite de tiempo a la ejecución *de 5 min* inicialmente pero es modificable mediante un parámetro. Si termina debe mostrar:
  - La mejor ruta hasta ese momento.
  - Mensaje diciendo que no se garantiza que sea óptimo.
- Generar instancias aleatorias de N nodos para probar los algoritmos y así poder hacer la experimentación.

## Cómo funciona este proyecto
Este proyecto implementa y compara tres algoritmos para resolver el problema del Viajante de Comercio (Traveling Salesman Problem - TSP): Fuerza Bruta, Voraz y Programación Dinámica. A continuación, se describe el flujo de trabajo:

### Entrada de datos:
Los grafos se leen desde ficheros en el formato especificado en el ejemplo anterior.
También es posible generar grafos aleatorios especificando el número de nodos y los valores mínimo y máximo de los pesos de las aristas.

### Ejecución de algoritmos:
El usuario puede elegir qué algoritmo ejecutar mediante argumentos de línea de comandos.
También es posible comparar los tres algoritmos en términos de tiempo de ejecución y calidad de la solución.

#### Límite de tiempo:
Para evitar tiempos de ejecución excesivos, especialmente con el algoritmo de Fuerza Bruta, se establece un límite de tiempo configurable (por defecto, 5 minutos).
Si un algoritmo no termina dentro del tiempo límite, se muestra la mejor solución encontrada hasta ese momento junto con un mensaje indicando que no se garantiza la optimalidad.

#### Límite de Instancia:
Para la ejecución del algoritmo de programación dinámica se ha decidido poner un límite al tamaño máximo de problemas a resolver
de 23, ya que utilizaría demasiada memoria RAM en nuestros sistemas llenando así el heap del programa.

#### Salida de resultados:
Los resultados incluyen la ruta encontrada, el costo total y el tiempo de ejecución.
Los resultados pueden imprimirse en consola o guardarse en un fichero.

#### Comparación de algoritmos:
Cuando se activa el modo de comparación, se ejecutan los tres algoritmos sobre las mismas instancias y se muestran los resultados en una tabla comparativa.
Generación de instancias aleatorias:

El proyecto incluye una funcionalidad para generar grafos aleatorios con un número configurable de nodos y pesos de aristas (aleatorias por defecto), lo que permite realizar experimentos con diferentes tamaños de grafos.

## Ejecución
Para ejecutar el proyecto, utiliza el siguiente comando desde la raíz del proyecto:
```bash
mvn exec:java -Dexec.mainClass="DynamicProgramming.Main" -Dexec.args="<argumentos>"
```

### Argumentos disponibles:
- p <path>: Ruta donde se encuentran los ficheros de entrada.
- if <input-file>: Nombre del fichero de entrada.
- of <output-file>: Nombre del fichero de salida.
- a <algorithm>: Algoritmo a ejecutar (BruteForce, Greedy, Dynamic, BruteGreedy).
- c: Activa el modo de comparación entre algoritmos.
- t <time-limit>: Límite de tiempo en segundos.
- r: Genera un grafo aleatorio.
- n <node-number>: Número de nodos para el grafo aleatorio.
- m <min-value>: Valor mínimo para los pesos de las aristas.
- M <max-value>: Valor máximo para los pesos de las aristas.

### Ejemplo de uso
- Comparar algoritmos en un conjunto de grafos:
```bash
mvn exec:java -Dexec.mainClass="DynamicProgramming.Main" -Dexec.args="-p input/ -c -t 300"
```

- Generar un grafo aleatorio:
```bash
mvn exec:java -Dexec.mainClass="DynamicProgramming.Main" -Dexec.args="-r -n 10 -m 1 -M 10 -of output.txt"
```

- Ejecutar el algoritmo de Fuerza Bruta en un grafo específico:
```bash
mvn exec:java -Dexec.mainClass="DynamicProgramming.Main" -Dexec.args="-p input/ -if graph.txt -a BruteForce -t 60 -of output.txt"
```