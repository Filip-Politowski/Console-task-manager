package pl.CodersLab;

import java.io.IOException;

import static pl.CodersLab.ConsoleColors.RED;
import static pl.CodersLab.ConsoleColors.RESET;

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

                    options.remove(FileManagement.readFromFile("TMFC/tasks.csv"));

                    options.optionsDisplay();
                    break;
                case "list":
                    options.List(dataFromFile);

                    options.optionsDisplay();
                    break;
                case "exit":
                    options.exit();
                    break;
                default:
                    System.out.println(RED + "invalid input" + RESET);
                    options.optionsDisplay();
                    break;


            }
        } while (!"exit".equals(input));

    }

}