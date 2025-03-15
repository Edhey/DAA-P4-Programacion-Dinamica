package DynamicProgramming.Graph;

import java.util.ArrayList;

import DynamicProgramming.Node.Node;

public class Graph {
  // private ArrayList<Arist> arists;
  private ArrayList<Node> nodes;

  public Graph() {
    // this.arists = new ArrayList<Arist>();
    this.nodes = new ArrayList<Node>();
  }

  public Graph(ArrayList<Node> nodes) {
    this.nodes = nodes;
  }

  // public void addArists(Arist arists) {
  //   this.arists.add(arists);
  // }

  public void addNode(Node node) {
    this.nodes.add(node);
  }

  public ArrayList<Node> getNodes() {
    return this.nodes;
  }
}
