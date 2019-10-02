package com.company;

import java.io.*;

/*
Write a program that saves and loads the information about a custom object using ObjectInputStream and
ObjectOutputStream.
Create a simple class called "Course" that has a String field containing its name and an integer field containing the
number of students attending the course. Set the name of the save file as course.ser.
 */
public class SerializeCustomObjectExercise {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("/Users/gangov/Downloads/object.ser");
        ObjectOutputStream makeSer = new ObjectOutputStream(output);

        Course course = new Course("Math", 50);

        makeSer.writeObject(course);
    }

    static class Course implements Serializable {
        String name;
        int studentsCount;

        public Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }
    }
}
