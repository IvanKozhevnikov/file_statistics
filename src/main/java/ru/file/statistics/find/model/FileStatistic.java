package ru.file.statistics.find.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "fileStatistic")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileStatistic {

    @Getter
    @XmlElement(name = "numberOfFile")
    private int numberOfFiles;
    @Getter
    @XmlElement(name = "sizeInBytes")
    private String sizeInBytes;
    @Getter
    @XmlElement(name = "totalNumberOfLines")
    private String totalNumberOfLines;
    @Getter
    @XmlElement(name = "numberOfNonEmptyLines")
    private String numberOfNonEmptyLines;
    @Getter
    @XmlElement(name = "numberOfLinesWithComments")
    private String numberOfLinesWithComments;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileStatistic that = (FileStatistic) o;
        return sizeInBytes == that.sizeInBytes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeInBytes);
    }

    @Override
    public String toString() {
        return "FileStatistic{" +
                "numberOfFiles=" + numberOfFiles +
                ", sizeInBytes=" + sizeInBytes +
                ", totalNumberOfLines=" + totalNumberOfLines +
                ", numberOfNonEmptyLines=" + numberOfNonEmptyLines +
                ", numberOfLinesWithComments=" + numberOfLinesWithComments +
                '}';
    }
}
