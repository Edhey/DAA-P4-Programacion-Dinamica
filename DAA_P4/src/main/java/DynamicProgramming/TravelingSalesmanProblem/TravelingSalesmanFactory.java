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
 * @desc Factory class that returns the Traveling Salesman Problem algorithm selected.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.ArgsParser.TSPAlgorithm;

public class TravelingSalesmanFactory {
  public static TravelingSalesmanProblem getTravelingSalesmanProblem(TSPAlgorithm algorithm) {
    switch (algorithm) {
      case BRUTE_FORCE:
        return new BruteForceAproach();
      case GREEDY:
        return new GreedyAproach();
      case DYNAMIC:
        return new DynamicProgramming();
      case BRUTE_GREEDY:
        return new BruteGreedyAproach();
      default:
        return null;
    }
  }
}
