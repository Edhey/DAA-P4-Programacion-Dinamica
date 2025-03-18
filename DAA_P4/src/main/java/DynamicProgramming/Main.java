/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Informatic Engineering Degree
 * Subject: Diseño y Análisis de Algoritmos
 * Practice 4 - Dynamic Programming
 *
 * @author Himar Edhey Hernández Alonso
 * @author Aarón Jano Barreto
 * @since 16/03/2025
 * @desc Main class of the project.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

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
              "BruteForce Time(µs)",
              "Dynamic Value",
              "Dynamic Time(µs)",
              "Greedy Value",
              "Greedy Time(µs)");
        }

        for (Path file : stream) {
          Graph graph = GraphInputManager.readInputFromFile(file.toString());
          String filePath = file.getFileName().toString();
          if (parser.comparison) {
            algorithmComparison(graph, filePath, parser.timeLimit);
          } else {
            algorithmExecution(graph, TravelingSalesmanFactory.getTravelingSalesmanProblem(parser.algorithm),
                parser.timeLimit);
          }
        }
      } catch (IOException | DirectoryIteratorException error) {
        error.printStackTrace();
      }
    }
  }

  private static void algorithmExecution(Graph graph, TravelingSalesmanProblem tsp, int timeLimitSec) {
    if (graph.getNodes().size() <= 2) {
      System.out.println("The graph must have at least 3 nodes.");
      return;
    }
    
    System.out.println("Algorithm: " + tsp.getClass().getSimpleName());
    ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
    ArrayList<Node> solution = new ArrayList<Node>();
    Interrumped interrumped = new Interrumped();
    Clock clock = new Clock();
    clock.start();
    solution = (tsp.solve(graph, nodes.get(0).getName(), timeLimitSec * 1000, interrumped));
    clock.stop();
    if (interrumped.get()) {
      System.out.println("The algorithm was interrupted.");
    }
    
    System.out.println("Time: " + clock.getTimeMicroseconds() + " µs");
    System.out.println("Solution Path:");
    int counter = 0;

    if (solution == null) {
      System.out.println("No solution found." + "\n");
      return;
    }
    for (Node node : solution) {
      counter++;
      if (solution.size() == counter) {
        System.out.print(node.getName());
        System.out.println();
        break;
      }
      System.out.print(node.getName() + " -> ");
    }
    System.out.println("Total Cost: " + tsp.getPathCost() + "\n");
  }

  private static void algorithmComparison(Graph graph, String fileName, int timeLimitSec) {
    if (graph.getNodes().size() <= 2) {
      System.out.println("The graph must have at least 3 nodes.");
      return;
    }
    String bruteForceValue = "0";
    String bruteForceTime = "0";
    String dynamicProgrammingValue = "0";
    String dynamicProgrammingTime = "0";
    String greedyValue = "0";
    String greedyTime = "0";
    for (TSPAlgorithm algorithm : TSPAlgorithm.values()) {
      TravelingSalesmanProblem tsp = TravelingSalesmanFactory.getTravelingSalesmanProblem(algorithm);
      ArrayList<String> result = getTimeAndValueTSP(tsp, graph, graph.getNodes().iterator().next().getName(), timeLimitSec);
      switch (algorithm) {
        case BRUTE_FORCE:
          bruteForceValue = result.get(0);
          bruteForceTime = result.get(1);
          break;
        case DYNAMIC:
          dynamicProgrammingValue = result.get(0);
          dynamicProgrammingTime = result.get(1);
          break;
        case GREEDY:
          greedyValue = result.get(0);
          greedyTime = result.get(1);
          break;
        default:
          break;
      }
    }

    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-15s %-20s%n",
        fileName,
        bruteForceValue,
        bruteForceTime,
        dynamicProgrammingValue,
        dynamicProgrammingTime,
        greedyValue,
        greedyTime);
  }

  private static ArrayList<String> getTimeAndValueTSP(TravelingSalesmanProblem algorithm, 
  Graph graph, String startNode, int timeLimitSec) {
    Clock clock = new Clock();
    int value = -1;
    long time = 0;
    Interrumped interrumped = new Interrumped();

    clock.start();
    algorithm.solve(graph, startNode, timeLimitSec * 1000, interrumped);
    value = algorithm.getPathCost();


    clock.stop();
    if (time != -1) {
      time = clock.getTimeMicroseconds();
    }

    ArrayList<String> result = new ArrayList<String>();
    result.add(String.valueOf(value));
    if (interrumped.get()) {
      result.add("EXCESIVE");
    } else {
      result.add(String.valueOf(time));
    }
    return result;
  }
}