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
 * @desc Class that represents a clock to measure the time of the algorithms.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.ArgsParser;

/**
 * Enum that represents the different algorithms for the Traveling Salesman Problem.
 */
public enum TSPAlgorithm {
  BRUTE_FORCE("BruteForce"),
  GREEDY("Greedy"),
  DYNAMIC("Dynamic"),
  BRUTE_GREEDY("BruteGreedy");
  
  private final String algorithm;

  /**
   * Constructor of the enum.
   * @param algorithm
   */
  TSPAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  /**
   * Getter for the algorithm.
   * @return The algorithm.
   */
  public String getAlgorithm() {
    return this.algorithm;
  }

  /**
   * Method that returns the algorithm from a string.
   * @param text
   * @return The algorithm.
   */
  public static TSPAlgorithm fromString(String text) {
    for (TSPAlgorithm algorithm : TSPAlgorithm.values()) {
      if (algorithm.algorithm.equalsIgnoreCase(text)) {
        return algorithm;
      }
    }
    throw new IllegalArgumentException("No enum constant " + TSPAlgorithm.class.getCanonicalName() + "." + text);
  }
}
