package ru.file.statistics.find.recursive;

import ru.file.statistics.find.model.Statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

public class RecursiveSearchFile  {

    public List<Statistics> searchRecursive(Path root
            , int maxDepth, String proccesFilesPattern, String noProccesFilesPattern) throws IOException {
        int pattern = 0;
        List<Statistics> list;
        SearchFilesFileVisitor searchFilesPatternFirst = new SearchFilesFileVisitor(p -> p.toFile().getName().matches(proccesFilesPattern), root, pattern);
        Files.walkFileTree(root, new HashSet<>(), maxDepth, searchFilesPatternFirst);
        list = searchFilesPatternFirst.getPaths();
        pattern = 1;
        SearchFilesFileVisitor searchFilesPatternSecond = new SearchFilesFileVisitor(p -> p.toFile().getName().matches(noProccesFilesPattern), root, pattern);
        Files.walkFileTree(root, new HashSet<>(), maxDepth, searchFilesPatternSecond);
        list.addAll(searchFilesPatternSecond.getPaths());
        return list;
    }
}
