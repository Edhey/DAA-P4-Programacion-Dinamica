package DynamicProgramming.InputManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Node.Node;

public class InputManager {
  public static Graph readInput(String path) {
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
}