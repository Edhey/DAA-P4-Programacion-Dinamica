package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;
import java.math.BigInteger;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

public class DynamicProgramming extends TravelingSalesmanProblem {
  final int INF = Integer.MAX_VALUE / 2; // Para evitar overflow
  private int[][] dist = null;
  private int[][] parent = null;
  private BigInteger[][] dp = null; // Cambiamos dp a BigInteger para manejar máscaras grandes
  private int numberOfNodes = 0;

  @Override
  public ArrayList<Node> solve(Graph graph, String startNode) {
    this.dist = graphToMatrix(graph);
    this.numberOfNodes = dist.length;
    this.dp = new BigInteger[1 << numberOfNodes][numberOfNodes];
    this.parent = new int[1 << numberOfNodes][numberOfNodes];
    for (BigInteger[] row : dp) {
      for (int i = 0; i < row.length; i++) {
        row[i] = BigInteger.valueOf(-1);
      }
    }
    for (int[] row : parent) {
      for (int i = 0; i < row.length; i++) {
        row[i] = -1;
      }
    }
    this.pathCost = recursiveSolve(BigInteger.ONE, 0);
    ArrayList<Integer> optimalPath = getOptimalPath();
    ArrayList<Node> path = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>(graph.getNodes());
    for (int i = 0; i < optimalPath.size(); i++) {
      path.add(nodes.get(optimalPath.get(i)));
    }
    return path;
  }

  private int recursiveSolve(BigInteger mask, int pos) {
    if (mask.equals(BigInteger.ONE.shiftLeft(numberOfNodes).subtract(BigInteger.ONE))) {
      return dist[pos][0]; // Return to starting city
    }

    if (!dp[mask.intValue()][pos].equals(BigInteger.valueOf(-1))) {
      return dp[mask.intValue()][pos].intValue();
    }

    int minCost = INF;
    int bestPrev = -1; // Para rastrear el camino óptimo

    for (int next = 0; next < numberOfNodes; next++) {
      if (mask.and(BigInteger.ONE.shiftLeft(next)).equals(BigInteger.ZERO)) { // If city is not visited
        int newCost = dist[pos][next] + recursiveSolve(mask.or(BigInteger.ONE.shiftLeft(next)), next);
        if (newCost < minCost) {
          minCost = newCost;
          bestPrev = next; // Save the best decision so far
        }
      }
    }
    parent[mask.intValue()][pos] = bestPrev; // Save the best decision
    dp[mask.intValue()][pos] = BigInteger.valueOf(minCost);
    return minCost;
  }

  public ArrayList<Integer> getOptimalPath() {
    ArrayList<Integer> path = new ArrayList<>();
    BigInteger mask = BigInteger.ONE;
    int pos = 0; // Start from city 0

    while (true) {
      path.add(pos);
      int next = parent[mask.intValue()][pos];
      if (next == -1) break; // There is no next city
      mask = mask.or(BigInteger.ONE.shiftLeft(next));
      pos = next;
    }
    path.add(0); // Return to starting city
    return path;
  }

  static public int[][] graphToMatrix(Graph graph) {
    int[][] matrix = new int[graph.getNodes().size()][graph.getNodes().size()];
    ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      for (int j = 0; j < nodes.size(); j++) {
        if (i == j) {
          matrix[i][j] = 0;
          continue;
        }
        matrix[i][j] = graph.getEdge(node, nodes.get(j)).getCost();
        matrix[j][i] = graph.getEdge(node, nodes.get(j)).getCost();
      }
    }
    return matrix;
  }
}