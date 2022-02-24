package org.epam.util;


import epam.Student;

import java.util.Comparator;

public class Comparators {

    private final Comparator<Student> sortByName = Comparator.comparing(Student::getName);

    private final Comparator<Student> sortByAvgGrade = Comparator.comparing(Student::getAvgGrade);

    public Comparator<Student> getSortByName() {
        return sortByName;
    }

    public Comparator<Student> getSortByAvgGrade() {
        return sortByAvgGrade;
    }


}
