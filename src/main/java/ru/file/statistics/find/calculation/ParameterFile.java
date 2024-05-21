package ru.file.statistics.find.calculation;

import java.io.*;
import java.nio.file.Path;

public class ParameterFile {

    public static int[] countParameterFiles(Path path) {
        try {
            String str;
            BufferedReader f = new BufferedReader(new FileReader(path.toFile()));
            LineNumberReader l = new LineNumberReader(f);
            int numberline = 0;
            int countNotEmpty = 0;
            int countComment = 0;
            while ((str = l.readLine()) != null) {
                numberline++;
                if (!str.startsWith(" ")) {
                    countNotEmpty++;
                } else if (str.startsWith("//")) {
                    countComment++;
                }
            }
            return new int[]{numberline, countNotEmpty, countComment};
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
