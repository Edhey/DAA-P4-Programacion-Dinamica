package DynamicProgramming.ArgsParser;

public enum TSPAlgorithm {
  BRUTE_FORCE("BruteForce"),
  GREEDY("Greedy"),
  DYNAMIC("Dynamic");
  
  private final String algorithm;

  TSPAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }


  public String getAlgorithm() {
    return this.algorithm;
  }

  public static TSPAlgorithm fromString(String text) {
    for (TSPAlgorithm algorithm : TSPAlgorithm.values()) {
      if (algorithm.algorithm.equalsIgnoreCase(text)) {
        return algorithm;
      }
    }
    throw new IllegalArgumentException("No enum constant " + TSPAlgorithm.class.getCanonicalName() + "." + text);
  }
}
