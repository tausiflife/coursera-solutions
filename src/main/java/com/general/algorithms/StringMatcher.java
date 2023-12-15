package com.general.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringMatcher {

    /**
     * Two strings, if second string is the substring of first.
     */

    public boolean isSubString(String original, String str) {
        if (original == null || str == null || original.isEmpty() || str.isEmpty())
            return false;
        char[] originalArray = original.toCharArray();
        char[] chars = str.toCharArray();
        int length = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (length < chars.length && originalArray[i] == chars[length]) {
                length++;
            } else {
                length = 0;
            }
            if (length == chars.length)
                return true;
        }
        return false;
    }

    public List<Student> getDuplicates() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("a", 80));
        list.add(new Student("b", 87));
        list.add(new Student("b", 70));
        list.add(new Student("a", 70));
        return list.stream().distinct().filter(student -> student.marks > 75).collect(Collectors.toList());
    }
}

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
