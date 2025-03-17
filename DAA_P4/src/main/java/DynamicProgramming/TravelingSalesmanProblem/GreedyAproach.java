package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

public class GreedyAproach extends TravelingSalesmanProblem {
  @Override
  public ArrayList<Node> solve(Graph graph, String startNodeName, long timeLimitMiliseconds, Interrumped interrumped) {
    Node startNode = null;
    for (Node node : graph.getNodes()) {
      if (node.getName().equals(startNodeName)) {
        startNode = node;
        break;
      }
    }
    ArrayList<Node> path = new ArrayList<Node>();
    path.add(startNode);
    Node actualNode = startNode;
    while (path.size() < graph.getNodes().size()) {
      Edge bestEdge = null;
      Node nextNode = null;
      for (Edge edge : graph.getEdges()) {
        if (edge.hasNode(actualNode)) {
          nextNode = edge.getDestination().equals(actualNode) ? edge.getOrigin() : edge.getDestination();
          if (!path.contains(nextNode)) {
            if (bestEdge == null || edge.getCost() < bestEdge.getCost()) {
              bestEdge = edge;
            }
          }
        }
      }
      nextNode = bestEdge.getDestination().equals(actualNode) ? bestEdge.getOrigin() : bestEdge.getDestination();
      path.add(nextNode);
      this.pathCost += bestEdge.getCost();
      actualNode = nextNode;
    }
    this.pathCost += graph.getEdge(actualNode, startNode).getCost();
    path.add(startNode);
    return path;
  }
}
