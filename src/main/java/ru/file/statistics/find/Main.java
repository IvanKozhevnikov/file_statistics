package ru.file.statistics.find;

import ru.file.statistics.find.convert.ProccesFilesPattern;
import ru.file.statistics.find.start.StatisticSearch;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of(args[0]);
        String typeSearch = args[1];
        int maxDepth = Integer.parseInt(args[2]);
        int thread = Integer.parseInt(args[3]);
        String proccesFilesPattern = ProccesFilesPattern.pattern(args[4]);
        String noProccesFilesPattern = ProccesFilesPattern.pattern(args[5]);
        String outputFormat = args[6];

        ExecutorService pool = Executors.newFixedThreadPool(thread);

        Runnable r = () -> {
            try {
                StatisticSearch.getStatistics(path, typeSearch, maxDepth, proccesFilesPattern, noProccesFilesPattern, outputFormat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        pool.execute(r);
        pool.shutdown();
    }
}
