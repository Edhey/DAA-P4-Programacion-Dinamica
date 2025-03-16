package DynamicProgramming.TravelingSalesmanProblem.TSPPrinter;

import java.util.ArrayList;

import DynamicProgramming.Graph.Node.Node;

public class TSPConsolePrinter implements TSPPrinter {
  @Override
  public void printSolution(ArrayList<Node> solution) {
    System.out.println("Solution: ");
    for (Node node : solution) {
      System.out.print(node.getName() + " -> ");
    }
    System.out.println(solution.get(0).getName());
  }
}
