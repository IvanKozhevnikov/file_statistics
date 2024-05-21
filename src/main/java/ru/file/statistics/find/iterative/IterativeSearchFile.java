package ru.file.statistics.find.iterative;

import ru.file.statistics.find.calculation.ParameterFile;
import ru.file.statistics.find.model.Statistics;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IterativeSearchFile {

    public List<Statistics> searchIterative(Path root, int maxDepth, String proccesFilesPattern, String noProccesFilesPattern) throws IOException {
        List<Statistics> list = new ArrayList<>();
        Files.walk(root, maxDepth)
                .filter(path -> {
                    File file = path.toFile();
                    return file.getName().matches(proccesFilesPattern);
                })
                .forEach(path -> {
                    int[] paramFile = ParameterFile.countParameterFiles(path);
                    list.add(new Statistics(path.getFileName().toString(), 1, path.toFile().length(), paramFile[0], paramFile[1], paramFile[2]));

                });

        Files.walk(root, maxDepth)
                .filter(path -> {
                    File file = path.toFile();
                    return file.getName().matches(noProccesFilesPattern);
                })
                .forEach(path -> {
                    list.add(new Statistics(path.getFileName().toString(), 1, 0L,
                            0, 0, 0));
                });
        return list;
    }
}
