package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Node.Node;
import java.util.ArrayList;

public abstract class TravelingSalesmanProblem {
  private Graph graph;
  private int pathCost;

  public TravelingSalesmanProblem(Graph graph) {
    this.graph = graph;
    this.pathCost = 0;
  }

  public abstract ArrayList<Node> solve(String startNodeName);

  public final void printSolution(ArrayList<Node> solution) {
    System.out.println("Solution: ");
    for (Node node : solution) {
      System.out.print(node.getName() + " -> ");
    }
    System.out.println(solution.get(0).getName());
  }

  public final int getPathCost() {
    return this.pathCost;
  }
}