package DynamicProgramming.Graph.GraphPrinter;

import java.io.FileWriter;
import java.util.ArrayList;

import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Node.Node;

public class GraphFilePrinter implements GraphPrinter {
  @Override
  public void print(Graph graph) {
    try {
      ArrayList<Node> nodes = graph.getNodes();
      int nodeNumber = nodes.size();
      FileWriter fileWriter = new FileWriter(nodeNumber + "-node-graph.txt");
      fileWriter.write(nodeNumber + "\n");
      for (Node node : graph.getNodes()) {
        fileWriter.write(node.toString() + "\n");
      }
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}