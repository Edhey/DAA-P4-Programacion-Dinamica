package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.ArgsParser.TSPAlgorithm;

public class TravelingSalesmanFactory {
  public static TravelingSalesmanProblem getTravelingSalesmanProblem(TSPAlgorithm algorithm) {
    switch (algorithm) {
      case BRUTE_FORCE:
        return new BruteForceAproach();
      case GREEDY:
        return new GreedyAproach();
      case DYNAMIC:
        return new DynamicProgramming();
      default:
        return null;
    }
  }
}
