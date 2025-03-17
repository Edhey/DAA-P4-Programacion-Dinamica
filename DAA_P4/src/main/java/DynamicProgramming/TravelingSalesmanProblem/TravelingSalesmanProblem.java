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
 * @desc Abstract class that represents the Traveling Salesman Problem.
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 */

package DynamicProgramming.TravelingSalesmanProblem;

import DynamicProgramming.Graph.*;
import DynamicProgramming.Graph.Node.Node;

import java.util.ArrayList;

public abstract class TravelingSalesmanProblem {
  protected int pathCost;

  public abstract ArrayList<Node> solve(Graph graph, String startNodeName, long timeLimitMiliseconds, Interrumped interrumped);

  public final int getPathCost() {
    return this.pathCost;
  }
}