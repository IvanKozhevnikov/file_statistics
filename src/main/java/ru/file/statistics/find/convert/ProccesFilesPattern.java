package ru.file.statistics.find.convert;

public class ProccesFilesPattern {

    public static String pattern(String str) {
        String[] extensions = str.split(",");
        String result = "";

        for (String ext : extensions) {
            result += ".*\\." + ext + "|";
        }

        return result.substring(0, result.length() - 1);
    }
}


