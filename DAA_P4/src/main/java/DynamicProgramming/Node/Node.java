package DynamicProgramming.Node;

import java.util.ArrayList;

public class Node {
  private String name;
  private ArrayList<NodeRelation> adjacents;

  public Node(String name) {
    this.name = name;
    this.adjacents = new ArrayList<>();
  }

  public void addAdjacent(Node node, Double cost) {
    this.adjacents.add(new NodeRelation(node, cost));
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<NodeRelation> getAdjacents() {
    return this.adjacents;
  }

  public void print() {
    System.out.println("Node: " + this.name);
    System.out.println("Adjacents:");
    for (NodeRelation adjacent : this.adjacents) {
      System.out.println("  " + adjacent.getNeighbour().getName() + " - " + adjacent.getCost());
    }
  }
}