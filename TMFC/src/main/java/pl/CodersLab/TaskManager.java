package pl.CodersLab;

import java.io.IOException;




public class TaskManager {
    public static void main(String[] args) throws IOException {
        String[][] dataFromFile = FileManagement.readFromFile("tasks.csv");
        options.optionsDisplay();
        String input;


        do {

            switch (input = options.getOption()) {
                case "add":
                    System.out.println("Add");
                    break;
                case "remove":
                    System.out.println("Remove");
                    break;
                case "list":
                    System.out.println("List");
                    break;
                case "exit":
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("invalid input");
                    break;

            }
        }while (!"exit".equals(input));

    }

}