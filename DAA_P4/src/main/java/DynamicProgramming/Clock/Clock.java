/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Informatic Engineering Degree
 * Subject: Diseño y Análisis de Algoritmos
 * Practice 3 - Divide and Conquer
 *
 * @author Himar Edhey Hernández Alonso
 * @author Aarón Jano Barreto
 * @since 16/03/2025
 * @desc Class that represents a clock to measure the time of the algorithms.
 *
 */

package DynamicProgramming.Clock;

/**
 * Class that represents a clock to measure the time of the algorithms.
 */
public class Clock {
  private long startTime;
  private long endTime;
  private boolean running;

  /**
   * Constructor for the Clock class.
   */
  public Clock() {
    this.running = false;
  }
  
  /**
   * Starts the clock.
   */
  public void start() {
    startTime = System.nanoTime();
    running = true;
  }

  /**
   * Stops the clock.
   */
  public void stop() {
    endTime = System.nanoTime();
    running = false;
  }

  /**
   * Restarts the clock.
   */
  public void restart() {
    running = false;
    startTime = 0;
    endTime = 0;
  }

  /**
   * Returns the time in seconds.
   * 
   * @return The time in seconds.
   */
  public double getTimeSeconds() {
    return running ? (System.nanoTime() - startTime) / 1_000_000_000.0
                     : (endTime - startTime) / 1_000_000_000.0;
  }

  /**
   * Returns the time in milliseconds.
   * 
   * @return The time in milliseconds.
   */
  public long getTimeMiliseconds() {
      return running ? (System.nanoTime() - startTime) / 1_000_000
                      : (endTime - startTime) / 1_000_000;
  }

  /**
   * Returns the time in microseconds.
   * 
   * @return The time in microseconds.
   */
  public long getTimeMicroseconds() {
    return running ? (System.nanoTime() - startTime) / 1_000
                    : (endTime - startTime) / 1_000;
  }
}