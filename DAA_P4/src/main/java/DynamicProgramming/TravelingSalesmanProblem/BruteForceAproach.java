package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Node.Node;

public class BruteForceAproach extends TravelingSalesmanProblem {
  @Override
  public ArrayList<Node> solve(Graph graph, String startNodeName) {
    Node startNode = null;
    for (Node node : graph.getNodes()) {
      if (node.getName().equals(startNodeName)) {
        startNode = node;
        break;
      }
    }
    ArrayList<Node> bestPath = new ArrayList<Node>();
    ArrayList<Node> path = new ArrayList<Node>();
    path.add(startNode);
    bestPath.add(startNode);
    AtomicInteger bestPathCost = new AtomicInteger(Integer.MAX_VALUE);
    recursiveSolve(graph, bestPath, bestPathCost, path, 0);
    
    this.pathCost = bestPathCost.get();
    System.out.println("Cost: " + this.pathCost);
    return bestPath;
  }
  
  public void recursiveSolve(Graph graph, ArrayList<Node> bestPath, AtomicInteger bestPathCost, 
      ArrayList<Node> path, int currentCost) {
    Node currentNode = path.get(path.size() - 1);
    for (Edge edge : graph.getEdges()) {
      ArrayList<Node> currentPath = new ArrayList<Node>(path);
      if (edge.hasNode(currentNode)) {
        Node nextNode = edge.getOrigin().equals(currentNode) ? edge.getDestination() : edge.getOrigin();
        if (!currentPath.contains(nextNode)) {
          currentPath.add(nextNode);
          int newCost = (int) (currentCost + edge.getCost());
          if (currentPath.size() == graph.getNodes().size()) {
            newCost += graph.getEdge(currentPath.get(currentPath.size() - 1), currentPath.get(0)).getCost();
            if (newCost < bestPathCost.get()) {
              bestPathCost.set(newCost);
              bestPath.clear();
              bestPath.addAll(currentPath);
              bestPath.add(currentPath.get(0));
            }
            return;
          }
          recursiveSolve(graph, bestPath, bestPathCost, currentPath, newCost);
        }
      }
    }
  }
}