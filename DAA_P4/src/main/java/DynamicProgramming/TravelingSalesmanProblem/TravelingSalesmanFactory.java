package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.ArgsParser.TSPAlgorithm;

public class TravelingSalesmanFactory {
  public static TravelingSalesmanProblem getTravelingSalesmanProblem(TSPAlgorithm algorithm) {
    switch (algorithm) {
      case BRUTE_FORCE:
        return new BruteForceAproach();
      case VORAZ:
        return new VorazAproach();
      case DYNAMIC:
        return new DinamicPrograming();
      default:
        return null;
    }
  }
}
