package com.goleg.labo.Labo.course;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {
    
	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

    @GetMapping("/")
	public List<Course> getCourse() {
	    return courseService.getCourse();
    }

	@PostMapping("/")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}

	@DeleteMapping("/{courseId}")
	public void deleteCourse(@PathVariable("courseId") Integer courseId) {
		courseService.deleteCourse(courseId);
	}

	@PutMapping("/{courseId}")
	public void updateCourse(
			@PathVariable("courseId") Integer courseId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) LocalDate createdAt) {
		courseService.updateCourse(courseId, name, createdAt);
	}
	
}
