package com.goleg.labo.Labo.course;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourse() {
		return courseRepository.findAll();
	}

    public void addCourse(Course course) {
        // System.out.println(course);
        Optional<Course> courseOptional = courseRepository.findCourseByName(course.getName());

        if (courseOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        courseRepository.save(course);
    }

    public void deleteCourse(Integer courseId) {
        boolean exist = courseRepository.existsById(courseId);
        if (!exist) {
            throw new IllegalStateException("Course with ID" + courseId + "does not exist");
        }

        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void updateCourse(Integer courseId, String name, LocalDate createdAt) {
        Course course = courseRepository.findById(courseId).orElseThrow(
            () -> new IllegalStateException(
                "Course with ID " + courseId + "does not exist"
            )
        );

        // Nama tidak kosong, Panjang nama lebih dari 0, nama yang di update tidak sama dengan yang lama
        if (name != null && name.length() > 0 && !Objects.equals(course.getName(), name)) {
            course.setName(name);
        }

        if (createdAt != null && !Objects.equals(course.getCreatedAt(), createdAt)) {
            course.setCreatedAt(createdAt);
        }

    }

}
