package DynamicProgramming.TravelingSalesmanProblem;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

public class BruteForceAproach extends TravelingSalesmanProblem  {
  @Override
  public ArrayList<Node> solve(Graph graph, String startNodeName, long timeLimitMiliSeconds, Interrumped interrumped) {
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

    Thread taskThread = new Thread(() -> {
      try {
        recursiveSolve(graph, bestPath, bestPathCost, path, 0);
      } catch (InterruptedException error) {
        interrumped.set(true);
      }
    });

    taskThread.start();

    try {
      taskThread.join(timeLimitMiliSeconds);
      if (taskThread.isAlive()) {
        taskThread.interrupt();
        interrumped.set(true);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
      interrumped.set(true);
    }

    this.pathCost = bestPathCost.get();
    return bestPath;
  }

  private void recursiveSolve(Graph graph, ArrayList<Node> bestPath, AtomicInteger bestPathCost,
      ArrayList<Node> path, int currentCost) throws InterruptedException {
    if (Thread.currentThread().isInterrupted()) {
      throw new InterruptedException();
    }
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