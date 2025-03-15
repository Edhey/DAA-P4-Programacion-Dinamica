package DynamicProgramming.InputManager;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Node.Node;

public class InputManager {
  public static Graph readInput(String path) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String linea;
      linea = br.readLine();
      int numberOfNodes = Integer.parseInt(linea);
      ArrayList<Node> generatedNodes = new ArrayList<Node>();
      Node firstNode = null;
      Node secondNode = null;
      while ((linea = br.readLine()) != null) {
        String[] parts = linea.split(" ");        boolean firstIsGenerated = false;
        boolean secondIsGenerated = false;
        for (Node node : generatedNodes) {
          if (node.getName() == parts[0]) {
            firstNode = node;
            firstIsGenerated = true;
            break;
          }
          if (node.getName() == parts[1]) {
            secondNode = node;
            secondIsGenerated = true;
            break;
          }
        }
        if (!firstIsGenerated) {
          Node node = new Node(parts[0]);
          generatedNodes.add(node);
          firstNode = node;
        }
        if (!secondIsGenerated) {
          Node node = new Node(parts[1]);
          generatedNodes.add(node);
          secondNode = node;
        }
        firstNode.addAdjacent(secondNode, Integer.parseInt(parts[2]));
        secondNode.addAdjacent(firstNode, Integer.parseInt(parts[2]));

      }
      return new Graph(generatedNodes);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}