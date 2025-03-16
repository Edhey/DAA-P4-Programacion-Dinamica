package DynamicProgramming.Graph.Node;

import java.util.Objects;

public class Node {
  private String name;

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null || getClass() != obj.getClass())
      return false;
    Node node = (Node) obj;
    return Objects.equals(name, node.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public void print() {
    System.out.println("Node: " + this.name);
  }
}