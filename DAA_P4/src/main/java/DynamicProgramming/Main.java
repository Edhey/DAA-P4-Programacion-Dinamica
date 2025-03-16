package DynamicProgramming;

import java.util.ArrayList;

import DynamicProgramming.ArgsParser.*;
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
    Graph graph = InputManager.readInput(parser.file);
    graph.print();

    TravelingSalesmanProblem tspBruteForce = new BruteForceAproach();
    ArrayList<Node> resultBruteForce = tspBruteForce.solve(graph, "A");
    System.out.println("Result: ");
    for (Node node : resultBruteForce) {
      System.out.println(node.getName());
    }
    
    TravelingSalesmanProblem tspVoraz = new VorazAproach();
    ArrayList<Node> resultVoraz = tspVoraz.solve(graph, "A");
    System.out.println("Result: ");
    for (Node node : resultVoraz) {
      System.out.println(node.getName());
    }

    Graph graphRandom = GraphGenerator.generateGraph(parser.nodeNumber);
    graphRandom.print();

    TravelingSalesmanProblem tspBruteForceRandom = new BruteForceAproach();
    ArrayList<Node> resultBruteForceRandom = tspBruteForceRandom.solve(graphRandom, "1");
    System.out.println("Result: ");
    for (Node node : resultBruteForceRandom) {
      System.out.println(node.getName());
    }

    TravelingSalesmanProblem tspVorazRandom = new VorazAproach();
    ArrayList<Node> resultVorazRandom = tspVorazRandom.solve(graphRandom, "1");
    System.out.println("Result: ");
    for (Node node : resultVorazRandom) {
      System.out.println(node.getName());
    }
    // int[][] polla = DinamicPrograming.graphToMatrix(graph);
    // for (int i = 0; i < polla.length; i++) {
    //   for (int j = 0; j < polla[i].length; j++) {
    //     System.out.print(polla[i][j] + " ");
    //   }
    //   System.out.println();
    // }
  }
}