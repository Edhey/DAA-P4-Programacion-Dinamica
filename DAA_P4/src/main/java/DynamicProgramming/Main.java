package DynamicProgramming;

import java.util.ArrayList;

import DynamicProgramming.ArgsParser.*;
import DynamicProgramming.Graph.*;
import DynamicProgramming.Graph.GraphPrinter.GraphFilePrinter;
import DynamicProgramming.Graph.GraphPrinter.GraphPrinter;
import DynamicProgramming.Graph.Node.Node;
import DynamicProgramming.TravelingSalesmanProblem.*;
import DynamicProgramming.TravelingSalesmanProblem.TSPPrinter.TSPPrinter;

/**
 * Main class of the project.
 */
public class Main {
  public static void main(String[] args) {
    ArgsParser parser = new ArgsParser(args);
    if (parser.random) {
      // Generate a random graph
      Graph graph = GraphGenerator.generateGraph(parser.nodeNumber);
      // Save the graph to a file
      GraphPrinter printer = new GraphFilePrinter(parser.path, parser.outputFile);
      printer.print(graph);
    } else {
      // Read the graph from the files in the directory
      ArrayList<Graph> graph = GraphInputManager.readInputFromDirectory(parser.path);

      if (parser.comparison) {
        // Compare the algorithms
        algorithmComparison(parser);
      } else {
        // Execute the algorithm
        algorithmExecution(parser);
      }
    }
  }

  public static void algorithmExecution(Graph graph, TravelingSalesmanProblem tsp) {
    ArrayList<Node> solution = tsp.solve(graph);
  }

  public static void algorithmComparison(ArgsParser options) {
    
  }
}