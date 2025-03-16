package DynamicProgramming.Graph.GraphPrinter;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;

public class GraphConsolePrinter implements GraphPrinter {
  @Override
  public void print(Graph graph) {
    System.out.println("Graph:");
    for (Edge edge : graph.getEdges()) {
      System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestination().getName() + " : " + edge.getCost());      
    }
  }
}
