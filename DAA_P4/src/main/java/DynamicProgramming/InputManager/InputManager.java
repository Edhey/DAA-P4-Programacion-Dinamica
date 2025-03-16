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
      int numberOfNodes = Integer.parseInt(linea);
      Node firstNode = null;
      Node secondNode = null;
      Graph graph = new Graph();
      while ((linea = bufferedReader.readLine()) != null) {
        String[] parts = linea.split(" ");        
        boolean firstIsGenerated = false;
        boolean secondIsGenerated = false;
        for (Node node : graph.getNodes()) {
          if (node.getName().equals(parts[0])) {
            firstNode = node;
            firstIsGenerated = true;
          }
          if (node.getName().equals(parts[1])) {
            secondNode = node;
            secondIsGenerated = true;
          }
        }
        if (!firstIsGenerated) {
          firstNode = new Node(parts[0]);
          graph.getNodes().add(firstNode);
        }
        if (!secondIsGenerated) {
          secondNode = new Node(parts[1]);
          graph.getNodes().add(secondNode);
        }
        graph.addEdge(firstNode, secondNode, Integer.parseInt(parts[2]));
      }
      return graph;
    } catch (IOException error) {
      error.printStackTrace();
    }
    return null;
  }
}