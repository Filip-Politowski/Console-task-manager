package pl.CodersLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class FileManagement {
    public static String[][] readFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        List<String> lines = Files.readAllLines(path);
        String[] taskRows = lines.toArray(new String[0]);
        String[][] elementsInRows = new String[taskRows.length][];

        for (int i = 0; i < taskRows.length; i++) {
            elementsInRows[i] = taskRows[i].split(",");
        }
        return elementsInRows;
    }

    public static void writeToFileAppend(String fileName, String userText) {

        Path path = Paths.get(fileName);

        try {
            Files.writeString(path, userText, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }

    }
    public static void writeToFile(String fileName, String userText) {

        Path path = Paths.get(fileName);

        try {
            Files.writeString(path, userText);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }

    }
 /*   public static List<String> readFromFileList(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        List<String> lines = Files.readAllLines(path);
        String[] taskRows = lines.toArray(new String[0]);
        String[][] elementsInRows = new String[taskRows.length][];

        for (int i = 0; i < taskRows.length; i++) {
            elementsInRows[i] = taskRows[i].split(",");
        }
        return lines;
    }*/
}
