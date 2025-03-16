package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Node.Node;
import DynamicProgramming.Graph.Graph;

public class DinamicPrograming extends TravelingSalesmanProblem {
  @Override
  public ArrayList<Node> solve(Graph graph, String startNode) {
    return new ArrayList<Node>();
  }

  static public int[][] graphToMatrix(Graph graph) {
    int[][] matrix = new int[graph.getNodes().size()][graph.getNodes().size()];
    ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      for (int j = 0; j < nodes.size(); j++) {
        matrix[i][j] = graph.getEdge(node, nodes.get(j)).getCost();
        matrix[j][i] = graph.getEdge(node, nodes.get(j)).getCost();
      }
    }
    return matrix;
  }
}