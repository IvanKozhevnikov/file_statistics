package ru.file.statistics.find.calculation;

import ru.file.statistics.find.model.FileStatistic;
import ru.file.statistics.find.model.Statistics;

import java.util.List;

public class StatisticsCalculation {

    public FileStatistic calculation(List<Statistics> list) {
        int numFiles = 0;
        long size = 0L;
        int total = 0;
        int numEmpLine = 0;
        int numLineComm = 0;
        for (Statistics statistics : list) {
            numFiles = numFiles + statistics.getNumberOfFiles();
            size = size + statistics.getSizeInBytes();
            total = total + statistics.getTotalNumberOfLines();
            numEmpLine = numEmpLine + statistics.getNumberOfNonEmptyLines();
            numLineComm = numLineComm + statistics.getNumberOfLinesWithComments();
        }
        return new FileStatistic(numFiles, String.valueOf(size), String.valueOf(total), String.valueOf(numEmpLine), String.valueOf(numLineComm));
    }
}
