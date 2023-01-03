package com.goleg.labo.Labo.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Find Course by Name
    @Query("SELECT c FROM Course c WHERE c.name = ?1")
    Optional<Course> findCourseByName(String name);

}
