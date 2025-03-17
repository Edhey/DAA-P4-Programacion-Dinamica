package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Graph.Node.Node;

import java.util.ArrayList;

public abstract class TravelingSalesmanProblem {
  protected int pathCost;

  public abstract ArrayList<Node> solve(Graph graph, String startNodeName);

  public final int getPathCost() {
    return this.pathCost;
  }
}