package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/*
Write a program that saves and loads an ArrayList of doubles to a file using ObjectInputStream and ObjectOutputStream.
Set the name of the file as list.ser.
 */
public class SerializeArrayListExercise {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> arrayToSer = new ArrayList<>(Arrays.asList(1.5, 2.5, 33.4, 5.4, 9.8));

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/gangov/Downloads/array.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(arrayToSer);
    }
}
