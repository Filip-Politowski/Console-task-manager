package pl.CodersLab;

import java.io.IOException;

public class TaskManager {
    public static void main(String[] args) throws IOException {

        options.optionsDisplay();
        String input;


        do {

            String[][] dataFromFile = FileManagement.readFromFile("TMFC/tasks.csv");

            switch (input = options.getOption()) {
                case "add":
                    FileManagement.writeToFileAppend("TMFC/tasks.csv", options.add());
                    options.optionsDisplay();
                    break;
                case "remove":


                    options.remove(Integer.parseInt(options.getOption()), FileManagement.readFromFile("TMFC/tasks.csv"));

                    options.optionsDisplay();
                    break;
                case "list":
                    options.List(dataFromFile);

                    options.optionsDisplay();
                    break;
                case "exit":
                    System.out.println("\n" +
                            "███████╗██╗░░░░░░█████╗░░█████╗░░█████╗░\n" +
                            "██╔════╝██║░░░░░██╔══██╗██╔══██╗██╔══██╗\n" +
                            "█████╗░░██║░░░░░██║░░██║██║░░██║██║░░██║\n" +
                            "██╔══╝░░██║░░░░░██║░░██║██║░░██║██║░░██║\n" +
                            "███████╗███████╗╚█████╔╝╚█████╔╝╚█████╔╝\n" +
                            "╚══════╝╚══════╝░╚════╝░░╚════╝░░╚════╝░");
                    break;
                default:
                    System.out.println("invalid input");
                    options.optionsDisplay();
                    break;


            }
        } while (!"exit".equals(input));

    }

}