package pl.CodersLab;

import java.io.IOException;


public class TaskManager {
    public static void main(String[] args) throws IOException {

        options.optionsDisplay();
        String input;


        do {
            String[][] dataFromFile = FileManagement.readFromFile("tasks.csv");

            switch (input = options.getOption()) {
                case "add":
                    FileManagement.writeToFile("tasks.csv",options.add());
                    options.optionsDisplay();
                    break;
                case "remove":
                    System.out.println("Remove");
                    options.optionsDisplay();
                    break;
                case "list":
                    options.List(dataFromFile);
                    options.optionsDisplay();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("invalid input");
                    options.optionsDisplay();
                    break;

            }
        } while (!"exit".equals(input));

    }

}