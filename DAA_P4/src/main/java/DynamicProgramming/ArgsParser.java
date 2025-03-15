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
package DynamicProgramming;

import org.apache.commons.cli.*;

/**
 * Class that parses the arguments from the command line.
 */
public class ArgsParser {
  public String file;
  public int timeLimit = 5;

  /**
   * Constructor for the ArgsParser class.
   * 
   * @param args The arguments from the command line.
   */
  public ArgsParser(String[] args) {
    Options options = new Options();

    options.addOption(Option.builder("f")
      .required()
      .longOpt("input-file")
      .desc("input file with the problem")
      .hasArg()
      .argName("file")
      .build());
    options.addOption(Option.builder("t")
      .longOpt("time-limit")
      .desc("time limit for the execution in minutes")
      .hasArg()
      .argName("limit")
      .build());

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    try {
      CommandLine cmd = parser.parse(options, args);
      file = cmd.getOptionValue("input-file");
      if (cmd.hasOption("time-limit")) {
        timeLimit = Integer.parseInt(cmd.getOptionValue("time-limit"));
      }
      
    } catch (ParseException e) {
      System.err.println("Error en los argumentos: " + e.getMessage());
      formatter.printHelp("java CommandLineExample", options);
      System.exit(1);
    }
  }
}