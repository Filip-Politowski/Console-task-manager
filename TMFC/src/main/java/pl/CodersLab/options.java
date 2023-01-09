package pl.CodersLab;

import org.apache.commons.lang3.StringUtils;

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

    public static String getOption(){
        Scanner scanner = new Scanner(System.in);
        return StringUtils.deleteWhitespace(scanner.nextLine().toLowerCase());
    }

}
