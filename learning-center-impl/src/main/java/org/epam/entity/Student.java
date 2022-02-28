package org.epam.entity;

import lombok.Data;
import org.epam.annotation.InjectRandomInt;

import java.io.Serializable;
import java.util.Map;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @InjectRandomInt(min=10, max = 100)
    private int id;
    private String name;

    private int programId;

    private Map<String, Integer> marks;

    private double avgGrade;

    public Student(int id, String name, int programId, Map<String, Integer> marks, double avgGrade) {
        this.id = id;
        this.name = name;
        this.programId = programId;
        this.marks = marks;
        this.avgGrade = avgGrade;
    }

    public Student() {
    }
}
