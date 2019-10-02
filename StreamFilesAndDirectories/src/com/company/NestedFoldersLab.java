package com.company;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/*
You are provided a folder named "Files-and-Streams". Create a program that lists the names of all directories in it
(including all nested directories).
On the last line, print the count of all folders, including the root folder.
 */
public class NestedFoldersLab {
    public static void main(String[] args) {

        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/Files-and-Streams";
        File file = new File(path);

        File[] files = file.listFiles();

        ArrayDeque<File> toScanThrough = new ArrayDeque<>(Arrays.asList(files));

        int count = 0;
        while (toScanThrough.size() > 0) {
            File current = toScanThrough.poll();

            if (current.isDirectory()) {
                System.out.println(current.getName());
                List<File> filesList = Arrays.asList(current.listFiles());
                toScanThrough.addAll(filesList);
                count++;
            }
        }

        System.out.println(count + " folders");

    }
}
