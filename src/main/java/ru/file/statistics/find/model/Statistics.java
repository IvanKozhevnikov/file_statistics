package ru.file.statistics.find.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    @Getter
    private String name;
    @Getter
    private int numberOfFiles;
    @Getter
    private long sizeInBytes;
    @Getter
    private int totalNumberOfLines;
    @Getter
    private int numberOfNonEmptyLines;
    @Getter
    private int numberOfLinesWithComments;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics responce = (Statistics) o;
        return name.equals(responce.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Responce{" +
                "name='" + name + '\'' +
                ", numberOfFiles=" + numberOfFiles +
                ", sizeInBytes=" + sizeInBytes +
                ", totalNumberOfLines=" + totalNumberOfLines +
                ", numberOfNonEmptyLines=" + numberOfNonEmptyLines +
                ", numberOfLinesWithComments=" + numberOfLinesWithComments +
                '}';
    }
}
