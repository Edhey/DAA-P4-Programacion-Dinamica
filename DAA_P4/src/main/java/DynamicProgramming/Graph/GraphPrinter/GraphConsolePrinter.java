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
 * @desc Class that represents a printer for the graph by console.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.Graph.GraphPrinter;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;

/**
 * Class that represents a printer for the graph by console.
 */
public class GraphConsolePrinter implements GraphPrinter {
  /**
   * Prints the graph by console.
   * @param graph Graph to print.
   */
  @Override
  public void print(Graph graph) {
    System.out.println("Graph:");
    for (Edge edge : graph.getEdges()) {
      System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestination().getName() + " : " + edge.getCost());      
    }
  }
}
