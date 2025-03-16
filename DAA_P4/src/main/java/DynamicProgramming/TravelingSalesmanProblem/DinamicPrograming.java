package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

public class DinamicPrograming extends TravelingSalesmanProblem {
  final int INF = Integer.MAX_VALUE / 2; // Para evitar overflow
  private int[][] dist = null;
  private int[][] dp = null;
  private int[][] parent = null;
  private int numberOfNodes = 0;
  private int optimalCost = 0;

  @Override
  public ArrayList<Node> solve(Graph graph, String startNode) {
    this.dist = graphToMatrix(graph);
    this.numberOfNodes = dist.length;
    this.dp = new int[1 << numberOfNodes][numberOfNodes];
    this.parent = new int[1 << numberOfNodes][numberOfNodes];
    for (int[] row : dp) {
      for (int i = 0; i < row.length; i++) {
        row[i] = -1;
      }
    }
    for (int[] row : parent) {
      for (int i = 0; i < row.length; i++) {
        row[i] = -1;
      }
    }
    this.optimalCost = recursiveSolve(1, 0);
    ArrayList<Integer> optimalPath = getOptimalPath();
    ArrayList<Node> path = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>(graph.getNodes());
    for (int i = 0; i < optimalPath.size(); i++) {
      path.add(nodes.get(optimalPath.get(i)));
    }
    System.out.println("Optimal cost: " + optimalCost);
    int counter = 0;
    for (Node node : path) {
      counter++;
      if (path.size() == counter) {
        System.out.print(node.getName());
        System.out.println();
        break;
      }
      System.out.print(node.getName() + " -> ");
    }
    return path;
  }

  private int recursiveSolve(int mask, int pos) {
    if (mask == (1 << numberOfNodes) - 1)
      return dist[pos][0]; // Volver al inicio

    if (dp[mask][pos] != -1)
      return dp[mask][pos];

    int minCost = INF;
    int bestPrev = -1; // Para rastrear el camino óptimo

    for (int next = 0; next < numberOfNodes; next++) {
      if ((mask & (1 << next)) == 0) { // Si la ciudad no ha sido visitada
        int newCost = dist[pos][next] + recursiveSolve(mask | (1 << next), next);
        if (newCost < minCost) {
          minCost = newCost;
          bestPrev = next; // Guardamos la mejor ciudad previa
        }
      }
    }
    parent[mask][pos] = bestPrev; // Guardamos la mejor decisión
    return dp[mask][pos] = minCost;
  }

    public ArrayList<Integer> getOptimalPath() {
        ArrayList<Integer> path = new ArrayList<>();
        int mask = 1, pos = 0; // Comenzamos desde la ciudad 0

        while (true) {
            path.add(pos);
            int next = parent[mask][pos];
            if (next == -1) break; // Ya terminamos el recorrido
            mask |= (1 << next);
            pos = next;
        }
        path.add(0); // Volver a la ciudad inicial
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