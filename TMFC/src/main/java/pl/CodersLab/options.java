package pl.CodersLab;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Scanner;

import static pl.CodersLab.ConsoleColors.BLUE;
import static pl.CodersLab.ConsoleColors.RESET;

public class options {
    public static void optionsDisplay() {
        System.out.println(BLUE + "Pleas select an option:");
        System.out.print(RESET);
        String[] options = {"Add", "Remove", "List", "Exit"};
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static String getOption() {
        Scanner scanner = new Scanner(System.in);
        return StringUtils.deleteWhitespace(scanner.nextLine().toLowerCase());
    }

    public static void List(String[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + ": ");
            for (int i1 = 0; i1 < tasks[i].length; i1++) {
                System.out.print(tasks[i][i1]);
            }
            System.out.println();
        }
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
        return stringBuilder.toString();
    }

    public static void remove(int numberOfRow) throws IOException {
        String[][] remover = FileManagement.readFromFile("tasks.csv");
        StringBuilder stringBuilder = new StringBuilder();


        for (int i1 = 0; i1 < remover[numberOfRow].length; i1++) {
            remover[numberOfRow][i1] = StringUtils.remove("", remover[numberOfRow][i1]);
            System.out.println(remover[numberOfRow][i1]);
        }
        for (int i = 0; i < remover.length; i++) {
            if (i == numberOfRow) continue;
            for (int i1 = 0; i1 < remover[i].length; i1++) {

                if (i1 == remover[i1].length - 1) {
                    stringBuilder.append(remover[i][i1]);
                    stringBuilder.append("\n");
                    break;
                } else {
                    stringBuilder.append(remover[i][i1]).append(",").append(" ");
                }
            }
        }


        FileManagement.writeToFile("tasks.csv", stringBuilder.toString().trim());

    }
}
