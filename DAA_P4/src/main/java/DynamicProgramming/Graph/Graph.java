package DynamicProgramming.Graph;

import java.util.ArrayList;


import DynamicProgramming.Graph.GraphPrinter.*;
import DynamicProgramming.Node.Node;
import java.util.Set;
import java.util.HashSet;

public class Graph {
  private ArrayList<Edge> edges;
  private Set<Node> nodes;
  private GraphPrinter graphPrinter;

  public Graph() {
    this.edges = new ArrayList<Edge>();
    this.nodes = new HashSet<Node>();
    this.graphPrinter = new GraphConsolePrinter();
  }

  public Graph(Set<Node> nodes, ArrayList<Edge> edges) {
    this.nodes = nodes;
    this.edges = edges;
    this.graphPrinter = new GraphConsolePrinter();
  }

  public Graph(Set<Node> nodes, ArrayList<Edge> edges, GraphPrinter graphPrinter) {
    this.nodes = nodes;
    this.edges = edges;
    this.graphPrinter = graphPrinter;
  }

  public void addNode(Node node) {
    this.nodes.add(node);
  }
  
  public void addEdge(Node origin, Node destination, int cost) {
    this.edges.add(new Edge(origin, destination, cost));
  }
  
  public void addEdge(Edge edge) {
    this.edges.add(edge);
  }

  public Set<Node> getNodes() {
    return this.nodes;
  }

  public ArrayList<Edge> getEdges() {
    return this.edges;
  }

  public int getSize() {
    return this.nodes.size();
  }

  public void print() {
    this.graphPrinter.print(this);
  }

  public Edge getEdge(Node origin, Node destination) {
    for (Edge edge : this.edges) {
      if (edge.hasNode(origin) && edge.hasNode(destination)) {
        return edge;
      }
    }
    return null;
  }
}
