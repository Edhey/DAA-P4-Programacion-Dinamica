package DynamicProgramming.Node;

import java.util.ArrayList;

import DynamicProgramming.Node.NodeRelation;

public class Node {
  private String name;
  private ArrayList<NodeRelation<Node, Double>> adjacents;

  public Node(String name) {
    this.name = name;
    this.adjacents = new ArrayList<>();
  }

  public void addAdjacent(Node node, double weight) {
    this.adjacents.add(new NodeRelation<Node, Double>(node, weight));
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<NodeRelation<Node, Double>> getAdjacents() {
    return this.adjacents;
  }
}