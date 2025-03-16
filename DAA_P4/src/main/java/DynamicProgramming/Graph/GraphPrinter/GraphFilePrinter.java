package DynamicProgramming.Graph.GraphPrinter;

import java.io.FileWriter;
import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Graph.Node.Node;

public class GraphFilePrinter implements GraphPrinter {
  private String path = "";
  private String fileName = "";

  public GraphFilePrinter(String path, String fileName) {
    this.path = path;
  }

  public GraphFilePrinter() {}

  @Override
  public void print(Graph graph) {
    try {
      ArrayList<Edge> edges = graph.getEdges();
      int nodeNumber = graph.getSize();
      path += nodeNumber + fileName == "" ? fileName : "-node-graph.txt";
      FileWriter fileWriter = new FileWriter(path);
      fileWriter.write(nodeNumber + "\n");
      for (Edge edge : edges) {
        Node origin = edge.getOrigin();
        Node destination = edge.getDestination();
        int cost = edge.getCost();
        fileWriter.write(origin.getName() + " " + destination.getName() + " " + cost + "\n");
      }
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}