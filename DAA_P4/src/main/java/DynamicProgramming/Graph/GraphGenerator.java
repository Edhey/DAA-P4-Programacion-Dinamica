package DynamicProgramming.Graph;

import java.util.ArrayList;
import java.util.Set;

import DynamicProgramming.Graph.Node.Node;

import java.util.HashSet;

/**
 * Class that represents a graph.
 */
public class GraphGenerator {
  /**
   * Generates a graph with a number of nodes.
   * @param nodeNumber The number of nodes to generate.
   * @return The generated graph.
   */
  public static Graph generateGraph(int nodeNumber, int minSize, int maxSize) {
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 1; i <= nodeNumber; i++) {
      nodes.add(new Node(String.valueOf(i)));
    }
    Set<Node> nodesSet = new HashSet<>(nodes);

    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < nodes.size(); i++) {
      for (int j = i + 1; j < nodes.size(); j++) {
        edges.add(new Edge(nodes.get(i), nodes.get(j), (int) (Math.random() * (maxSize - minSize) + minSize)));
      }
    }
    return new Graph(nodesSet, edges);
  }
}