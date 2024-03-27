package com.stevezchao.carDistributionSystem.Entity.test;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class StudentPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private Set<CoursePO> courses = new HashSet<>();

    public static StudentPO of(String name) {
        var student = new StudentPO();
        student.name = name;

        return student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CoursePO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CoursePO> courses) {
        this.courses = courses;
    }
}