package DynamicProgramming.Graph;

import java.util.ArrayList;

import DynamicProgramming.Node.Node;

/**
 * Class that represents a graph.
 */
public class GraphGenerator {
  /**
   * Generates a graph with a number of nodes.
   * @param nodeNumber The number of nodes to generate.
   * @return The generated graph.
   */
  public static Graph generateGraph(int nodeNumber) {
    Graph graph = new Graph();
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < nodeNumber; i++) {
      nodes.add(new Node("Node " + i));
    }

    for (int i = 0; i < nodes.size(); i++) {
      for (int j = i + 1; j < nodes.size(); j++) {
        generateEdge(graph, nodes.get(i), nodes.get(j));
      }
    }
    return graph;
  }

  /**
   * Generates an arista between two nodes.
   * @param graph The graph to add the edge.
   * @param node1 The first node.
   * @param node2 The second node.
   */
  private static void generateEdge(Graph graph, Node node1, Node node2) {
    double weight = Math.random() * 100;
    node1.addAdjacent(node2, weight);
    node2.addAdjacent(node1, weight);
  }
}