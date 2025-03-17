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
 * @desc Class that represents a node of a graph.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.Graph.Node;

import java.util.Objects;

/**
 * Class that represents a node of a graph.
 */
public class Node {
  private String name;

  /**
   * Constructor of the class.
   * @param name Name of the node.
   */
  public Node(String name) {
    this.name = name;
  }

  /**
   * Getter of the name of the node.
   * @return Name of the node.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setter of the name of the node.
   * @param name Name of the node.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null || getClass() != obj.getClass())
      return false;
    Node node = (Node) obj;
    return Objects.equals(name, node.name);
  }

  /**
   * Setter of the name of the node.
   * @param name Name of the node.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  /**
   * Setter of the name of the node.
   * @param name Name of the node.
   */
  public void print() {
    System.out.println("Node: " + this.name);
  }
}