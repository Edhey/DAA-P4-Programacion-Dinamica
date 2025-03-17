package DynamicProgramming.TravelingSalesmanProblem;

public class Interrumped {
  private boolean value;

  public Interrumped(boolean value) {
    this.value = value;
  }

  public Interrumped() {
    this.value = false;
  }

  public void set(boolean value) {
    this.value = value;
  }

  public boolean get() {
    return this.value;
  }
}