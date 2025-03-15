package DynamicProgramming.Graph.GraphPrinter;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Node.Node;

public class GraphConsolePrinter implements GraphPrinter {
  @Override
  public void print(Graph graph) {
    System.out.println("Graph:");
    for (Node node : graph.getNodes()) {
      node.print();
    }
  }
}
