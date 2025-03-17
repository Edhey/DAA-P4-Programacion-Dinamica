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
 * @desc Class that represents a graph. 
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.Graph;

import java.util.ArrayList;


import DynamicProgramming.Graph.GraphPrinter.*;
import DynamicProgramming.Graph.Node.Node;

import java.util.Set;
import java.util.HashSet;

/**
 * Class that represents a graph.
 */
public class Graph {
  private ArrayList<Edge> edges;
  private Set<Node> nodes;
  private GraphPrinter graphPrinter;

  /**
   * Constructor for the graph.
   */
  public Graph() {
    this.edges = new ArrayList<Edge>();
    this.nodes = new HashSet<Node>();
    this.graphPrinter = new GraphConsolePrinter();
  }

  /**
   * Constructor for the graph.
   * @param nodes Nodes of the graph.
   * @param edges Edges of the graph.
   */
  public Graph(Set<Node> nodes, ArrayList<Edge> edges) {
    this.nodes = nodes;
    this.edges = edges;
    this.graphPrinter = new GraphConsolePrinter();
  }

  /**
   * Constructor for the graph.
   * @param nodes Nodes of the graph.
   * @param edges Edges of the graph.
   * @param graphPrinter Printer for the graph.
   */
  public Graph(Set<Node> nodes, ArrayList<Edge> edges, GraphPrinter graphPrinter) {
    this.nodes = nodes;
    this.edges = edges;
    this.graphPrinter = graphPrinter;
  }

  /**
   * Adds a node to the graph.
   * @param node Node to add.
   */
  public void addNode(Node node) {
    this.nodes.add(node);
  }
  
  /**
   * Adds an edge to the graph.
   * @param origin Origin node of the edge.
   * @param destination Destination node of the edge.
   * @param cost Cost of the edge.
   */
  public void addEdge(Node origin, Node destination, int cost) {
    this.edges.add(new Edge(origin, destination, cost));
  }
  
  /**
   * Adds an edge to the graph.
   * @param edge Edge to add.
   */
  public void addEdge(Edge edge) {
    this.edges.add(edge);
  }

  /**
   * Setter for the printer of the graph.
   * @param graphPrinter Printer of the graph.
   */
  public Set<Node> getNodes() {
    return this.nodes;
  }

  /**
   * Getter for the nodes of the graph.
   * @return Nodes of the graph.
   */
  public ArrayList<Edge> getEdges() {
    return this.edges;
  }

  /**
   * Getter for the edges of the graph.
   * @return Edges of the graph.
   */
  public int getSize() {
    return this.nodes.size();
  }

  /**
   * Prints the graph.
   */
  public void print() {
    this.graphPrinter.print(this);
  }

  /**
   * Getter for the edge between two nodes.
   * @param origin Origin node of the edge.
   * @param destination Destination node of the edge.
   * @return Edge between the two nodes.
   */
  public Edge getEdge(Node origin, Node destination) {
    for (Edge edge : this.edges) {
      if (edge.hasNode(origin) && edge.hasNode(destination)) {
        return edge;
      }
    }
    return null;
  }
}
