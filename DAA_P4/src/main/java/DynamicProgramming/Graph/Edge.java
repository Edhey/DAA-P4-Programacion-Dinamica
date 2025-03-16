package DynamicProgramming.Graph;

import DynamicProgramming.Graph.Node.Node;

public class Edge {
  private Node origin;
  private Node destination;
  private int cost;

  public Edge(Node origin, Node destination, int cost) {
    this.origin = origin;
    this.destination = destination;
    this.cost = cost;
  }

  public boolean hasNode(Node node) {
    return (this.origin.getName().equals(node.getName()) 
           || this.destination.getName().equals(node.getName()));
  }

  public Node getOrigin() {
    return this.origin;
  }

  public Node getDestination() {
    return this.destination;
  }

  public int getCost() {
    return this.cost;
  }
}
