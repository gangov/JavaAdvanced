package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Read the file provided, named "input.txt" and sort all lines. Write text to another text file. Use Path and Files
Classes.
 */
public class SortLinesLab {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/input.txt");
        Path output = Paths.get("/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(input);
        lines = lines.stream().filter(line -> !line.isBlank()).collect(Collectors.toList());
        Collections.sort(lines);
        Files.write(output, lines);
    }
}
