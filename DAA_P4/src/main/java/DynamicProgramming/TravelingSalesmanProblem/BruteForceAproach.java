package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Node.Node;

class BruteForceAproach extends TravelingSalesmanProblem {
  BruteForceAproach(Graph graph) {
    super(graph);
  }

  @Override
  public ArrayList<Node> solve(String startNodeName){
    ArrayList<Node> path = new ArrayList<Node>();
    for (Node node : graph.getNodes()) {
      if (node.getName().equals(startNodeName)) {
        path.add(node);
        break;
      }
    }
    recursiveSolve(path, path, path.get(0) , 0);
    return path;
  }

  private void recursiveSolve(ArrayList<Node> bestPath, ArrayList<Node> currentPath, Node actualNode , int currentCost) {
    for (Node node : graph.getNodes()) {
      
    }
  }
}