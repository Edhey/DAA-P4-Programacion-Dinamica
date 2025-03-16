package DynamicProgramming.Node;

public class Node {
  private String name;

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void print() {
    System.out.println("Node: " + this.name);
  }
}