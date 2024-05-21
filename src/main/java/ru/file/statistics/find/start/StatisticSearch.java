package ru.file.statistics.find.start;

import ru.file.statistics.find.calculation.StatisticsCalculation;
import ru.file.statistics.find.convert.ConvertGson;
import ru.file.statistics.find.convert.ConvertXml;
import ru.file.statistics.find.iterative.IterativeSearchFile;
import ru.file.statistics.find.recursive.RecursiveSearchFile;
import ru.file.statistics.find.model.FileStatistic;
import ru.file.statistics.find.model.Statistics;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class StatisticSearch {

    public static void getStatistics(Path root,
                                     String typeSearch, int maxDepth,
                                     String proccesFilesPattern, String noProccesFilesPattern,
                                     String outputFormat) throws IOException {

        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();

        if (typeSearch.equals("recursive")) {
            RecursiveSearchFile recursiveSearchFile = new RecursiveSearchFile();
            List<Statistics> list = recursiveSearchFile.searchRecursive(root
                    , maxDepth, proccesFilesPattern, noProccesFilesPattern);
            iterate(statisticsCalculation.calculation(list), outputFormat);
        } else if (typeSearch.equals("iterative")) {
            IterativeSearchFile iterativeSearchFile = new IterativeSearchFile();
            List<Statistics> list = iterativeSearchFile.searchIterative(root, maxDepth,
                    proccesFilesPattern, noProccesFilesPattern);
            iterate(statisticsCalculation.calculation(list), outputFormat);
        }
    }

    public static void iterate(FileStatistic fileStatistic, String outputFormat) {
        if (outputFormat.contains("gson") && outputFormat.contains("xml")) {
            convertGson(fileStatistic);
            convertXml(fileStatistic);
        } else if (outputFormat.equals("gson")) {
            convertGson(fileStatistic);
        } else if (outputFormat.equals("xml")) {
            convertXml(fileStatistic);
        }
    }

    public static void convertGson(FileStatistic fileStat) {
        ConvertGson convertGson = new ConvertGson();
        convertGson.convertGson(fileStat);
    }

    public static void convertXml(FileStatistic fileStat) {
        ConvertXml convertXml = new ConvertXml();
        convertXml.convertXml(fileStat);
    }
}
