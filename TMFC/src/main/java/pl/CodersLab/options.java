package pl.CodersLab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static pl.CodersLab.ConsoleColors.*;

public class options {
    public static void optionsDisplay() {
        System.out.println(BLUE + "Pleas select an option:" + RESET);
        String[] options = {"Add", "Remove", "List", "Exit"};
        System.out.print(PURPLE_BOLD);
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print(RESET);
    }

    public static String getOption() {
        Scanner scanner = new Scanner(System.in);
        return StringUtils.deleteWhitespace(scanner.nextLine().toLowerCase());
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int numberOfRow;
        while (true) {
            try {
                numberOfRow = Integer.parseInt(scanner.nextLine());
                if (numberOfRow < 0) {
                    System.out.println(RED + "Insert number equals or greater than 0" + RESET);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Wrong format, insert number equals or greater than 0 " + RESET);

            }
        }
        return numberOfRow;
    }

    public static void List(String[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(YELLOW);
            System.out.print(i + ": ");
            for (int i1 = 0; i1 < tasks[i].length; i1++) {
                System.out.print(tasks[i][i1]);
            }
            System.out.println();
        }
        System.out.print(RESET);
    }





    public static String add() {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] souty = {"Please add task description", "Due to date", "Select importance of task"};
        int count = 0;
        stringBuilder.append("\n");

        while (true) {
            System.out.println(souty[count]);
            line = scanner.nextLine();

            if (count == 2) {
                stringBuilder.append(line);
                break;
            } else {
                stringBuilder.append(line).append(",").append(" ");
                count++;
            }
        }
        System.out.println(GREEN + "Element added successfully" + RESET);

        return stringBuilder.toString();
    }

    public static void remove(String[][] tasks) {

        System.out.println("Insert the number of row: ");

        int numberOfRow = getNumber();
        StringBuilder stringBuilder = new StringBuilder();


        while (true) {
            if (numberOfRow < tasks.length) {
                tasks = ArrayUtils.remove(tasks, numberOfRow);
                break;
            } else {
                System.out.println(RED + "That element not exist in tab, last index of tab equals: " + (tasks.length - 1) + RESET);
                numberOfRow = getNumber();
            }
        }


        for (int i = 0; i < tasks.length; i++) {
            for (int i1 = 0; i1 < tasks[i].length; i1++) {

                if (i1 == tasks[i].length - 1) {
                    stringBuilder.append(tasks[i][i1]);
                    break;
                } else {
                    stringBuilder.append(tasks[i][i1]).append(",");
                }
            }
            stringBuilder.append("\n");
        }

        System.out.println(GREEN + "Element deleted successfully" + RESET);


        FileManagement.writeToFile("TMFC/tasks.csv", stringBuilder.toString().trim());

    }
}
