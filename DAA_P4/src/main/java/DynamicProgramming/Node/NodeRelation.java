package DynamicProgramming.Node;

class NodeRelation {
  private Node neighbour;
  private int cost;

  public NodeRelation(Node neighbour, int cost) {
    this.neighbour = neighbour;
    this.cost = cost;
  }

  public Node getNeighbour() {
    return neighbour;
  }

  public int getCost() {
    return cost;
  }

  public void setNeighbour(Node neighbour) {
    this.neighbour = neighbour;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}