package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.Graph.*;

abstract class TravelingSalesmanProblem {
    protected Graph graph;

    public TravelingSalesmanProblem() {
      this.graph = new Graph();
    }

    public abstract int tsp(int start);
}