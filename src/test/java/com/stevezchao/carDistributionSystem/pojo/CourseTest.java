package com.stevezchao.carDistributionSystem.pojo;

import com.stevezchao.carDistributionSystem.Entity.test.CoursePO;
import com.stevezchao.carDistributionSystem.Entity.test.StudentPO;
import com.stevezchao.carDistributionSystem.repo.CourseRepository;
import com.stevezchao.carDistributionSystem.repo.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    public void clearDB() {
//        studentRepository.deleteAll();
//        courseRepository.deleteAll();
    }

    @Test
    public void testManyToManyRelation() {
        // create courses
        CoursePO course1 = CoursePO.of("英文", 3);
        CoursePO course2 = CoursePO.of("計算機概論", 4);
        CoursePO course3 = CoursePO.of("會計學", 3);
        Set<CoursePO> courses = Set.of(course1, course2, course3);
        courseRepository.saveAll(courses);

        // create students
        StudentPO student1 = StudentPO.of("Vincent");
        StudentPO student2 = StudentPO.of("Ivy");
        studentRepository.saveAll(Set.of(student1, student2));

        // select courses
        course1.setStudents(Set.of(student1, student2));
        course2.setStudents(Set.of(student1));
        course3.setStudents(Set.of(student2));
        courseRepository.saveAll(courses);

        // query student and get related courses
        StudentPO dbStudent1 = studentRepository.findById(student1.getId()).orElseThrow();
        assertEquals(Set.of(course1, course2), dbStudent1.getCourses());

        StudentPO dbStudent2 = studentRepository.findById(student2.getId()).orElseThrow();
        assertEquals(Set.of(course1, course3), dbStudent2.getCourses());

        // query course and get related students
        CoursePO dbCourse1 = courseRepository.findById(course1.getId()).orElseThrow();
        assertEquals(Set.of(student1, student2), dbCourse1.getStudents());

        CoursePO dbCourse2 = courseRepository.findById(course2.getId()).orElseThrow();
        assertEquals(Set.of(student1), dbCourse2.getStudents());

        CoursePO dbCourse3 = courseRepository.findById(course3.getId()).orElseThrow();
        assertEquals(Set.of(student2), dbCourse3.getStudents());
    }
}
