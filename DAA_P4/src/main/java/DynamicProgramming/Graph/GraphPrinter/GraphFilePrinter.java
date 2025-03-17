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
 * @desc Class that represents a printer for the graph by file.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */


package DynamicProgramming.Graph.GraphPrinter;

import java.io.FileWriter;
import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

/**
 * Class that represents a printer for the graph by file.
 */
public class GraphFilePrinter implements GraphPrinter {
  private String path = "";
  private String fileName = "";

  /**
   * Constructor for the GraphFilePrinter class.
   * @param path Path to save the file.
   * @param fileName Name of the file.
   */
  public GraphFilePrinter(String path, String fileName) {
    this.path = path;
  }

  /**
   * Constructor for the GraphFilePrinter class without parameters.
   */
  public GraphFilePrinter() {}

  /**
   * Prints the graph by file.
   * @param graph Graph to print.
   */
  @Override
  public void print(Graph graph) {
    try {
      ArrayList<Edge> edges = graph.getEdges();
      int nodeNumber = graph.getSize();
      if (fileName == "") {
        fileName =  nodeNumber + "-node-graph.txt";
      }
      path += "/" + fileName;
      FileWriter fileWriter = new FileWriter(path);
      fileWriter.write(nodeNumber + "\n");
      for (Edge edge : edges) {
        Node origin = edge.getOrigin();
        Node destination = edge.getDestination();
        int cost = edge.getCost();
        fileWriter.write(origin.getName() + " " + destination.getName() + " " + cost + "\n");
      }
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}