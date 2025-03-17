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
 * @desc Class that represents a manager for the input of the graph.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */


package DynamicProgramming.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.nio.file.*;

import DynamicProgramming.Graph.Node.Node;

public class GraphInputManager {

  /**
   * Read a graph from a file and return it.
   */
  public static Graph readInputFromFile(String path) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
      String linea;
      linea = bufferedReader.readLine();
      Node firstNode = null;
      Node secondNode = null;
      Graph graph = new Graph();
      while ((linea = bufferedReader.readLine()) != null) {
        String[] parts = linea.split(" ");
        firstNode = new Node(parts[0]);
        graph.addNode(firstNode);
        secondNode = new Node(parts[1]);
        graph.addNode(secondNode);
        try {
          graph.addEdge(firstNode, secondNode, Integer.parseInt(parts[2]));
        } catch (NumberFormatException error) {
          System.err.println("Error: Bad graph description, the weight must be a number.");
        }
      }
      return graph;
    } catch (IOException error) {
      error.printStackTrace();
    }
    return null;
  }

  /**
   * Read all the files in a directory and return an ArrayList of Graphs.
   */
  public static ArrayList<Graph> readInputFromDirectory(String pathName) {
    Path path = Paths.get(pathName);
    ArrayList<Graph> graphs = new ArrayList<>();
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
      for (Path file : stream) {
        graphs.add(readInputFromFile(file.toString()));
      }
    } catch (IOException | DirectoryIteratorException error) {
      error.printStackTrace();
    }
    return graphs;
  }
}