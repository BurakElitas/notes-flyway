package com.burak.courseapp.service;

import com.burak.courseapp.dto.CourseRequest;
import com.burak.courseapp.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Long topicId);
    Course getCourse(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course, CourseRequest courseRequest);
    void deleteCourse(Long id);
}
