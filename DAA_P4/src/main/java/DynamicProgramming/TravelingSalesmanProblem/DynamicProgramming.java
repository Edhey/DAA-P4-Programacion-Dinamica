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
 * @desc Class that represents the dynamic programming algorithm for the Traveling Salesman Problem.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;
import java.math.BigInteger;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;
/**
 * Class that represents the dynamic programming algorithm for the Traveling Salesman Problem.
 */
public class DynamicProgramming extends TravelingSalesmanProblem {
  final int INFINITY = Integer.MAX_VALUE / 2; // To avoid overflow
  private int[][] distanceMatrix = null;
  private int[][] parentMatrix = null;
  private BigInteger[][] memoizationTable = null; // Changed dp to BigInteger to handle large masks
  private int totalNodes = 0;
  private static final int MAXIMUM_NODES = 22; 

  /**
   * Solves the Traveling Salesman Problem using dynamic programming.
   * @param graph Graph to solve.
   * @param startNode Starting node.
   * @param timeLimitMilliseconds Time limit in milliseconds.
   * @param interrupted Interruption flag.
   * @return The optimal path.
   */
  @Override
  public ArrayList<Node> solve(Graph graph, String startNode, long timeLimitMilliseconds, Interrumped interrupted) {
    this.distanceMatrix = graphToMatrix(graph);
    this.pathCost = -1;
    this.totalNodes = distanceMatrix.length;
    if (totalNodes >= MAXIMUM_NODES) {
      interrupted.set(true);
      return null;
    }
    this.memoizationTable = new BigInteger[1 << totalNodes][totalNodes];
    this.parentMatrix = new int[1 << totalNodes][totalNodes];
    for (BigInteger[] row : memoizationTable) {
      for (int i = 0; i < row.length; i++) {
        row[i] = BigInteger.valueOf(-1);
      }
    }
    for (int[] row : parentMatrix) {
      for (int i = 0; i < row.length; i++) {
        row[i] = -1;
      }
    }
    
    Thread computationThread = new Thread(() -> {
      this.pathCost = recursiveSolve(BigInteger.ONE, 0);      
    });

    computationThread.start();

    try {
        computationThread.join(timeLimitMilliseconds);
        if (computationThread.isAlive()) {
            computationThread.interrupt();
            interrupted.set(true);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
        interrupted.set(true);  
    }

    ArrayList<Integer> optimalPathIndices = getOptimalPath();
    ArrayList<Node> optimalPath = new ArrayList<>();
    ArrayList<Node> graphNodes = new ArrayList<>(graph.getNodes());
    for (int i = 0; i < optimalPathIndices.size(); i++) {
      optimalPath.add(graphNodes.get(optimalPathIndices.get(i)));
    }
    return optimalPath;
  }

  /**
   * Recursive method to solve the Traveling Salesman Problem.
   * @param visitedMask Mask to check visited cities.
   * @param currentNode Current city.
   * @return The cost of the optimal path.
   */
  private int recursiveSolve(BigInteger visitedMask, int currentNode) {
    if (Thread.currentThread().isInterrupted()) {
      return -1; // Return -1 to indicate that the solution was not found
    }
    
    if (visitedMask.equals(BigInteger.ONE.shiftLeft(totalNodes).subtract(BigInteger.ONE))) {
      return distanceMatrix[currentNode][0]; // Return to starting city
    }

    if (!memoizationTable[visitedMask.intValue()][currentNode].equals(BigInteger.valueOf(-1))) {
      return memoizationTable[visitedMask.intValue()][currentNode].intValue();
    }

    int minimumCost = INFINITY;
    int bestPreviousNode = -1; // To track the optimal path
    
    for (int nextNode = 0; nextNode < totalNodes; nextNode++) {
      if (visitedMask.and(BigInteger.ONE.shiftLeft(nextNode)).equals(BigInteger.ZERO)) { // If city is not visited
        int newCost = distanceMatrix[currentNode][nextNode] + recursiveSolve(visitedMask.or(BigInteger.ONE.shiftLeft(nextNode)), nextNode);
        if (newCost < minimumCost) {
          minimumCost = newCost;
          bestPreviousNode = nextNode; // Save the best decision so far
        }
      }
    }
    parentMatrix[visitedMask.intValue()][currentNode] = bestPreviousNode; // Save the best decision
    memoizationTable[visitedMask.intValue()][currentNode] = BigInteger.valueOf(minimumCost);

    return minimumCost;
  }

  /**
   * Get the optimal path.
   * @return The optimal path.
   */
  public ArrayList<Integer> getOptimalPath() {
    ArrayList<Integer> pathIndices = new ArrayList<>();
    BigInteger visitedMask = BigInteger.ONE;
    int currentNode = 0; // Start from city 0

    while (true) {
      pathIndices.add(currentNode);
      int nextNode = parentMatrix[visitedMask.intValue()][currentNode];
      if (nextNode == -1) break; // There is no next city
      visitedMask = visitedMask.or(BigInteger.ONE.shiftLeft(nextNode));
      currentNode = nextNode;
    }
    pathIndices.add(0); // Return to starting city
    return pathIndices;
  }

  static public int[][] graphToMatrix(Graph graph) {
    int[][] adjacencyMatrix = new int[graph.getNodes().size()][graph.getNodes().size()];
    ArrayList<Node> graphNodes = new ArrayList<Node>(graph.getNodes());
    for (int i = 0; i < graphNodes.size(); i++) {
      Node currentNode = graphNodes.get(i);
      for (int j = 0; j < graphNodes.size(); j++) {
        if (i == j) {
          adjacencyMatrix[i][j] = 0;
          continue;
        }
        adjacencyMatrix[i][j] = graph.getEdge(currentNode, graphNodes.get(j)).getCost();
        adjacencyMatrix[j][i] = graph.getEdge(currentNode, graphNodes.get(j)).getCost();
      }
    }
    return adjacencyMatrix;
  }
}

  // private void solve2(Graph graph, String startNode, long timeLimitMiliSeconds, Interrumped interrumped) {
  //   int[][] matrix = graphToMatrix(graph);
  //   int size = matrix.length;
  //   int[][] memo = new int[size][1 << size]; // Matrix of size size x 2^size

  //   setup(matrix, memo, startNode, size);
  //   recursiveSolve2(matrix, memo, startNode, size);
    
  //   this.pathCost = findMinCost(matrix, memo, startNode, size);
  //   return getOptimalPath2(matrix, memo, startNode, size);
  // }

  // private void setup(int[][] matrix, int[][] memo, String startNode, int size) {
  //   for (int i = 0; i < size; i++) {
  //     if (i == startNode) continue;
  //     memo[i][1 << i] = matrix[startNode][i];
  //   }
  // }

  // private void recursiveSolve2(int[][] matrix, int[][] memo, String startNode, int size) {
  //   for (int mask = 1; mask < (1 << size); mask++) {
  //     for (int i = 0; i < size; i++) {
  //       if (i == startNode || (mask & (1 << i)) == 0) continue;
  //       for (int j = 0; j < size; j++) {
  //         if (j == startNode || j == i || (mask & (1 << j)) == 0) continue;
  //         if (memo[i][mask] == 0 || memo[i][mask] > memo[j][mask ^ (1 << i)] + matrix[j][i]) {
  //           memo[i][mask] = memo[j][mask ^ (1 << i)] + matrix[j][i];
  //         }
  //       }
  //     }
  //   }
  // }

  // private int findMinCost(int[][] matrix, int[][] memo, String startNode, int size) {
  //   int minCost = Integer.MAX_VALUE;
  //   for (int i = 0; i < size; i++) {
  //     if (i == startNode) continue;
  //     if (minCost == 0 || minCost > memo[i][(1 << size) - 1] + matrix[i][startNode]) {
  //       minCost = memo[i][(1 << size) - 1] + matrix[i][startNode];
  //     }
  //   }
  //   return minCost;
  // }

  // private ArrayList<Node> getOptimalPath2(int[][] matrix, int[][] memo, String startNode, int size) {
  //   ArrayList<Node> path = new ArrayList<>();
  //   int mask = (1 << size) - 1;
  //   int pos = startNode;
  //   while (true) {
  //     path.add(pos);
  //     int next = -1;
  //     for (int i = 0; i < size; i++) {
  //       if (i == startNode || (mask & (1 << i)) == 0) continue;
  //       if (next == -1 || memo[pos][mask] > memo[i][mask ^ (1 << pos)] + matrix[i][pos]) {
  //         next = i;
  //       }
  //     }
  //     if (next == -1) break;
  //     mask ^= (1 << pos);
  //     pos = next;
  //   }
  //   path.add(startNode);
  //   return path;
  // }
