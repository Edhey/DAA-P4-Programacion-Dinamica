package DynamicProgramming.Graph.GraphPrinter;

import java.io.FileWriter;
import java.util.ArrayList;

import DynamicProgramming.Graph.Edge;
import DynamicProgramming.Graph.Graph;
import DynamicProgramming.Node.Node;

public class GraphFilePrinter implements GraphPrinter {
  @Override
  public void print(Graph graph) {
    try {
      ArrayList<Edge> edges = graph.getEdges();
      int nodeNumber = graph.getSize();
      FileWriter fileWriter = new FileWriter(nodeNumber + "-node-graph.txt");
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