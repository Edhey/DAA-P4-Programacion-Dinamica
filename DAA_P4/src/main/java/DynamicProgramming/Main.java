package DynamicProgramming;

import java.util.ArrayList;

import java.io.IOException;
import java.nio.file.*;

import DynamicProgramming.ArgsParser.*;
import DynamicProgramming.Graph.*;
import DynamicProgramming.Graph.GraphPrinter.GraphFilePrinter;
import DynamicProgramming.Graph.GraphPrinter.GraphPrinter;
import DynamicProgramming.Graph.Node.Node;
import DynamicProgramming.TravelingSalesmanProblem.*;
import DynamicProgramming.Clock.Clock;

/**
 * Main class of the project.
 */
public class Main {
  public static void main(String[] args) {
    ArgsParser parser = new ArgsParser(args);
    if (parser.random) {
      // Generate a random graph
      Graph graph = GraphGenerator.generateGraph(parser.nodeNumber, parser.minValue, parser.maxValue);
      // Save the graph to a file
      GraphPrinter printer = new GraphFilePrinter(parser.path, parser.outputFile);
      printer.print(graph);
    } else {
      // Read the graph from the files in the directory
      Path directoryPath = Paths.get(parser.path);
      try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
        if (parser.comparison) {
          System.out.printf("%-20s %-20s %-20s %-20s %-20s %-15s %-20s%n", 
            "Instance", 
            "BruteForce Value", 
            "BruteForce Time(ms)", 
            "Dynamic Value", 
            "Dynamic Time(ms)", 
            "Greedy Value", 
            "Greedy Time(ms)");
        }

        for (Path file : stream) {
          Graph graph = GraphInputManager.readInputFromFile(file.toString());
          String filePath = file.getFileName().toString();
          if (parser.comparison) {
            algorithmComparison(graph, filePath);
          } else {
            algorithmExecution(graph, TravelingSalesmanFactory.getTravelingSalesmanProblem(parser.algorithm));
          }
        }
      } catch (IOException | DirectoryIteratorException error) {
        error.printStackTrace();
      }
    }
  }

  public static void algorithmExecution(Graph graph, TravelingSalesmanProblem tsp) {
    if (graph.getNodes().size() <= 2) {
      System.out.println("The graph must have at least 3 nodes.");
      return;
    }
    ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
    ArrayList<Node> solution = tsp.solve(graph, nodes.get(0).getName());
    System.out.println("Solution Path:");
    int counter = 0;
    for (Node node : solution) {
      counter++;
      if (solution.size() == counter) {
        System.out.print(node.getName());
        System.out.println();
        break;
      }
      System.out.print(node.getName() + " -> ");
    }
    System.out.println("Total Cost: " + tsp.getPathCost());
  }

  public static void algorithmComparison(Graph graph, String fileName) {
    if (graph.getNodes().size() <= 2) {
      System.out.println("The graph must have at least 3 nodes.");
      return;
    }
    int bruteForceValue = 0;
    long bruteForceTime = 0;
    int dynamicProgrammingValue = 0;
    long dynamicProgrammingTime = 0;
    int greedyValue = 0;
    long greedyTime = 0;
    Clock clock = new Clock();
    
    BruteForceAproach bruteForce = new BruteForceAproach();
    clock.start();
    String firstNodeName = graph.getNodes().iterator().next().getName();
    bruteForce.solve(graph, firstNodeName);
    clock.stop();
    bruteForceValue = bruteForce.getPathCost();
    bruteForceTime = clock.getTimeMiliseconds();
    
    DynamicProgramming dynamicProgramming = new DynamicProgramming();
    clock.start();
    dynamicProgramming.solve(graph, firstNodeName);
    clock.stop();
    dynamicProgrammingValue = dynamicProgramming.getPathCost();
    dynamicProgrammingTime = clock.getTimeMiliseconds();
    
    GreedyAproach greedy = new GreedyAproach();
    clock.start();
    greedy.solve(graph, firstNodeName);
    clock.stop();
    greedyValue = greedy.getPathCost();
    greedyTime = clock.getTimeMiliseconds();

    System.out.printf("%-20s %-20d %-20d %-20d %-20d %-15d %-20d%n", 
      fileName, 
      bruteForceValue, 
      bruteForceTime, 
      dynamicProgrammingValue, 
      dynamicProgrammingTime, 
      greedyValue, 
      greedyTime);
  }
}