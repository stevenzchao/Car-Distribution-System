package com.stevezchao.carDistributionSystem.Entity.test;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.Set;

@Entity
@Table(name = "course")
public class CoursePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "point")
    private int point;

    @ManyToMany(targetEntity = StudentPO.class, fetch = FetchType.EAGER)
    @JoinTable(
            // 中間表名稱
            name = "selected_course",
            // 本類別與中間表的關聯
            joinColumns = @JoinColumn(name = "course", referencedColumnName = "course_id"),
            // 對方類別與中間表的關聯
            inverseJoinColumns = @JoinColumn(name = "student", referencedColumnName = "student_id")
    )
    private Set<StudentPO> students;

    public static CoursePO of(String name, int point) {
        var course = new CoursePO();
        course.name = name;
        course.point = point;

        return course;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Set<StudentPO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentPO> students) {
        this.students = students;
    }



}