package DynamicProgramming;

import DynamicProgramming.Graph.*;
import DynamicProgramming.InputManager.*;


/**
 * Main class of the project.
 */
public class Main {
  public static void main(String[] args) {
    ArgsParser parser = new ArgsParser(args);
    System.out.println(parser.file);
    System.out.println(parser.timeLimit);
    System.out.println(parser.nodeNumber);
    Graph graph = GraphGenerator.generateGraph(4);
    graph.print();

    Graph graph2 = InputManager.readInput(parser.file);
    graph2.print();
    
    // Graph graph = InputManager.readInput(parser.file);
    // TravelingSalesmanProblem tsp = new TravelingSalesmanProblem(graph);
    // int result = tsp.tsp(0);
    // System.out.println(result);
  }
}