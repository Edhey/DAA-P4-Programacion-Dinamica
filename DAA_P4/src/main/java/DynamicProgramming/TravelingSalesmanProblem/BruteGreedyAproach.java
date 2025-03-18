package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;


public class BruteGreedyAproach extends TravelingSalesmanProblem {
  /**
   * Solves the Traveling Salesman Problem using the greedy aproach for the 75% 
   * of the nodes and the brute force for the remaining 25%.
   * @param graph Graph to solve.
   * @param startNodeName Name of the node to start the path.
   * @param timeLimitMiliseconds Time limit to solve the problem.
   * @param interrumped Interrumped object to check if the execution has been interrupted.
   * @return ArrayList<Node> Path that solves the problem.
   */
  @Override
  public ArrayList<Node> solve(Graph graph, String startNodeName, long timeLimitMiliseconds, Interrumped interrumped) {
    GreedyAproach greedyAproach = new GreedyAproach();
    BruteForceAproach bruteForce = new BruteForceAproach();
    Graph greedyGraph = new Graph();
    ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
    for (int i = 0; i < (nodes.size() - 1) * 0.75; i++) {
      greedyGraph.addNode(nodes.get(i));
    }

    ArrayList<Node> remainingNodes = new ArrayList<Node>(graph.getNodes());
    remainingNodes.removeAll(greedyGraph.getNodes());

    Graph bruteGraph = new Graph();
    for (Node node : remainingNodes) {
      bruteGraph.addNode(node);
    }
    bruteGraph.addNode(nodes.get(0));

    for (Edge edge : graph.getEdges()) {
      if (greedyGraph.getNodes().contains(edge.getDestination()) && greedyGraph.getNodes().contains(edge.getOrigin())) {
        greedyGraph.addEdge(edge.getOrigin(), edge.getDestination(), edge.getCost());
      }
      if (bruteGraph.getNodes().contains(edge.getDestination()) && bruteGraph.getNodes().contains(edge.getOrigin())) {
        bruteGraph.addEdge(edge.getOrigin(), edge.getDestination(), edge.getCost());
      }
    }

    ArrayList<Node> greedyPath = greedyAproach.solve(greedyGraph, startNodeName, timeLimitMiliseconds, interrumped);
    ArrayList<Node> brutePath = bruteForce.solve(bruteGraph, startNodeName, timeLimitMiliseconds, interrumped);

    greedyPath.addAll(brutePath);
    this.pathCost = greedyAproach.getPathCost() + bruteForce.getPathCost();
    return greedyPath;
  }
}
