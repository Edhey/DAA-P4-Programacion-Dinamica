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
