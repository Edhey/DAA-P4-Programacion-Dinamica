package DynamicProgramming;

import java.util.ArrayList;

import DynamicProgramming.Graph.*;
import DynamicProgramming.InputManager.*;
import DynamicProgramming.TravelingSalesmanProblem.*;
import DynamicProgramming.Node.Node;

/**
 * Main class of the project.
 */
public class Main {
  public static void main(String[] args) {
    ArgsParser parser = new ArgsParser(args);
    Graph graph = GraphGenerator.generateGraph(parser.nodeNumber);
    graph.print();
    TravelingSalesmanProblem tsp = new BruteForceAproach(graph);
    ArrayList<Node> result = tsp.solve("1");
    System.out.println("Result: ");
    for (Node node : result) {
      System.out.println(node.getName());
    }


    // Graph graph2 = InputManager.readInput(parser.file);
    // TravelingSalesmanProblem tsp2 = new BruteForceAproach(graph2);

    // graph2.print();

    // ArrayList<Node> result2 = tsp2.solve("A");
    // System.out.println("Result: ");
    // for (Node node : result2) {
    //   System.out.println(node.getName());
    // }
    // System.out.println("Cost: " + tsp.getCost());
    
    // Graph graph = InputManager.readInput(parser.file);
    // TravelingSalesmanProblem tsp = new TravelingSalesmanProblem(graph);
    // int result = tsp.tsp(0);
    // System.out.println(result);
  }
}