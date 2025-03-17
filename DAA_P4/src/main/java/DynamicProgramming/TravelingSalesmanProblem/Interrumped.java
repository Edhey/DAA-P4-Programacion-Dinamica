/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Informatic Engineering Degree
 * Subject: Diseño y Análisis de Algoritmos
 * Practice 4 - Dynamic Programming
 *
 * @author Himar Edhey Hernández Alonso
 * @author Aarón Jano Barreto
 * @since 16/03/2025
 * @desc Class that represents an interruption. 
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.TravelingSalesmanProblem;

public class Interrumped {
  private boolean value;

  public Interrumped(boolean value) {
    this.value = value;
  }

  public Interrumped() {
    this.value = false;
  }

  public void set(boolean value) {
    this.value = value;
  }

  public boolean get() {
    return this.value;
  }
}