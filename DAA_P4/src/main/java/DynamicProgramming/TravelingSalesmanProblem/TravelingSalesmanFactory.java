package DynamicProgramming.TravelingSalesmanProblem;

public class TravelingSalesmanFactory {
  static TravelingSalesmanProblem getTravelingSalesmanProblem(String type) {
    switch (type) {
      case "BruteForce":
        return new BruteForceAproach();
      case "Voraz":
        return new VorazAproach();
      case "Dinamico":
        return new DinamicPrograming();
      default:
        return null;
    }
  }
}
