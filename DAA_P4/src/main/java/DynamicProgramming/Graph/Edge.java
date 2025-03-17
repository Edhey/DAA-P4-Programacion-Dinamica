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
 * @desc Class that represents an edge of the graph.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.Graph;

import DynamicProgramming.Graph.Node.Node;

/**
 * Class that represents an edge of the graph.
 */
public class Edge {
  private Node origin;
  private Node destination;
  private int cost;

  /**
   * Constructor of the class.
   * @param origin Origin node of the edge.
   * @param destination Destination node of the edge.
   * @param cost Cost of the edge.
   */
  public Edge(Node origin, Node destination, int cost) {
    this.origin = origin;
    this.destination = destination;
    this.cost = cost;
  }

  /**
   * Method that returns if the edge has a node.
   * @param node Node to check if the edge has.
   * @return True if the edge has the node, false otherwise.
   */
  public boolean hasNode(Node node) {
    return (this.origin.getName().equals(node.getName()) 
           || this.destination.getName().equals(node.getName()));
  }

  /**
   * Getter of the origin node of the edge.
   * @return Origin node of the edge.
   */
  public Node getOrigin() {
    return this.origin;
  }

  /**
   * Getter of the destination node of the edge.
   * @return Destination node of the edge.
   */
  public Node getDestination() {
    return this.destination;
  }

  /**
   * Getter of the cost of the edge.
   * @return Cost of the edge.
   */
  public int getCost() {
    return this.cost;
  }
}
