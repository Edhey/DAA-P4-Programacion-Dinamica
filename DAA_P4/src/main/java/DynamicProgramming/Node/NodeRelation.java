package DynamicProgramming.Node;

class NodeRelation {
  private Node neighbour;
  private Double cost;

  public NodeRelation(Node neighbour, Double cost) {
    this.neighbour = neighbour;
    this.cost = cost;
  }

  public Node getNeighbour() {
    return neighbour;
  }

  public Double getCost() {
    return cost;
  }

  public void setNeighbour(Node neighbour) {
    this.neighbour = neighbour;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }
}