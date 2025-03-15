package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Node.Node;
import java.util.ArrayList;

abstract class TravelingSalesmanProblem {
  protected Graph graph;

  public TravelingSalesmanProblem(Graph graph) {
    this.graph = graph;
  }

  public abstract ArrayList<Node> solve(String startNodeName);

  public void printSolution(ArrayList<Node> solution) {
    System.out.println("Solution: ");
    for (Node node : solution) {
      System.out.print(node.getName() + " -> ");
    }
    System.out.println(solution.get(0).getName());
  }
}