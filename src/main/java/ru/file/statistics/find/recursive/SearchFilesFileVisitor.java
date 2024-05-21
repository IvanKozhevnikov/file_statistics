package ru.file.statistics.find.recursive;

import ru.file.statistics.find.calculation.ParameterFile;
import ru.file.statistics.find.model.Statistics;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFilesFileVisitor implements FileVisitor<Path> {

    private final Predicate<Path> pathPredicate;
    private final Path root;
    private final List<Statistics> responceList = new ArrayList<>();
    private final int pattern;

    public SearchFilesFileVisitor(Predicate<Path> pathPredicate, Path path, int pattern) {
        this.pathPredicate = pathPredicate;
        this.root = path;
        this.pattern = pattern;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path pathVisit, BasicFileAttributes attrs) throws IOException {
        if (pathPredicate.test(pathVisit)) {
            String fileName = String.valueOf(pathVisit.getFileName());
            int[] paramFile = new int[0];
            long size = 0L;
            if (pattern == 0) {
                paramFile = ParameterFile.countParameterFiles(pathVisit);
                size = attrs.size();
            }
            else if (pattern == 1) {
                paramFile = new int[]{0, 0, 0};
                size = 0L;
            }
            responceList.add(new Statistics(fileName, 1, size, paramFile[0], paramFile[1], paramFile[2]));
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Statistics> getPaths() {
        return responceList;
    }
}

