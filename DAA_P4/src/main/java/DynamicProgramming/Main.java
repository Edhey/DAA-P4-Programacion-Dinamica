package DynamicProgramming;

/**
 * Main class of the project.
 */
public class Main {
  public static void main(String[] args) {
    ArgsParser parser = new ArgsParser(args);
    System.out.println(parser.file);
    System.out.println(parser.timeLimit);
    // Graph graph = InputManager.readInput(parser.file);
    // TravelingSalesmanProblem tsp = new TravelingSalesmanProblem(graph);
    // int result = tsp.tsp(0);
    // System.out.println(result);
  }
}