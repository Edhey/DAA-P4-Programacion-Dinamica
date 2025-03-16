/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Informatic Engineering Degree
 * Subject: Diseño y Análisis de Algoritmos
 * Practice 4 - Dynamic Programming
 *
 * @author Himar Edhey Hernández Alonso
 * @author Aarón Jano Barreto
 * @since 09/03/2025
 * @desc This class is responsible for parsing the arguments from the command line
 * @see https://github.com/Edhey/DAA-P4-Programacion-Dinamica
 *
 */
package DynamicProgramming.ArgsParser;

import org.apache.commons.cli.*;

/**
 * Class that parses the arguments from the command line.
 */
public class ArgsParser {
  public String inputFile;
  public String outputFile;
  public String path;
  public int timeLimit = 5;
  public int nodeNumber = 4;
  public TSPAlgorithm algorithm;
  public boolean comparison = true;
  public boolean random = true;

  /**
   * Constructor for the ArgsParser class.
   * 
   * @param args The arguments from the command line.
   */
  public ArgsParser(String[] args) {
    Options options = new Options();

    options.addOption(Option.builder("f")
        .longOpt("input-file")
        .desc("input file with the problem")
        .hasArg()
        .argName("file")
        .build());
    options.addOption(Option.builder("c")
        .longOpt("comparison")
        .desc("compare the algorithms")
        .build());
    options.addOption(Option.builder("a")
        .longOpt("algorithm")
        .desc("algorithm to use")
        .hasArg()
        .argName("algorithm")
        .build());
    options.addOption(Option.builder("t")
        .longOpt("time-limit")
        .desc("time limit for the execution in minutes")
        .hasArg()
        .argName("limit")
        .build());
    options.addOption(Option.builder("n")
        .longOpt("node-number")
        .desc("number of nodes to generate")
        .hasArg()
        .argName("number")
        .build());
    options.addOption(Option.builder("pr")
        .longOpt("printer")
        .desc("printer to use")
        .hasArg()
        .argName("printer")
        .build());
    options.addOption(Option.builder("r")
        .longOpt("random")
        .desc("generate a random graph")
        .build());
    options.addOption(Option.builder("o")
        .longOpt("output-file")
        .desc("output file with the solution")
        .hasArg()
        .argName("file")
        .build());
    options.addOption(Option.builder("p")
        .longOpt("path")
        .desc("path where the files are located")
        .hasArg()
        .argName("path")
        .build());

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    try {
      CommandLine cmd = parser.parse(options, args);
      if (cmd.hasOption("input-file"))
        inputFile = cmd.getOptionValue("input-file");
      if (cmd.hasOption("output-file"))
        outputFile = cmd.getOptionValue("output-file");
      if (cmd.hasOption("time-limit"))
        timeLimit = Integer.parseInt(cmd.getOptionValue("time-limit"));
      if (cmd.hasOption("node-number"))
      nodeNumber = Integer.parseInt(cmd.getOptionValue("node-number"));
      if (cmd.hasOption("path"))
        path = cmd.getOptionValue("path");
      if (cmd.hasOption("algorithm")) {
        try {
          algorithm = TSPAlgorithm.fromString(cmd.getOptionValue("algorithm"));
        } catch (IllegalArgumentException e) {
          System.err.println("Error en los argumentos: " + e.getMessage());
        }
      }      
      if (cmd.hasOption("comparison"))
        comparison = true;
      if (cmd.hasOption("random"))
        random = true;
    } catch (ParseException e) {
      System.err.println("Error en los argumentos: " + e.getMessage());
      formatter.printHelp("java CommandLineExample", options);
      System.exit(1);
    }
  }
}