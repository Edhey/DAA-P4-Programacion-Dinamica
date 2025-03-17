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
 * @desc Class that represents a greedy aproach for the Traveling Salesman Problem.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

/**
 * Class that represents a greedy aproach for the Traveling Salesman Problem.
 */
public class GreedyAproach extends TravelingSalesmanProblem {
  
  /**
   * Solves the Traveling Salesman Problem using a greedy aproach.
   * @param graph Graph to solve.
   * @param startNodeName Name of the node to start the path.
   * @param timeLimitMiliseconds Time limit to solve the problem.
   * @param interrumped Interrumped object to check if the execution has been interrupted.
   * @return ArrayList<Node> Path that solves the problem.
   */
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
