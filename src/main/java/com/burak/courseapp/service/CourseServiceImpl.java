package com.burak.courseapp.service;

import com.burak.courseapp.dto.CourseRequest;
import com.burak.courseapp.model.Course;
import com.burak.courseapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl  implements CourseService{

    private final CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Long topicId) {
        return courseRepository.getCoursesByTopicId(topicId);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Course not found with "+id));
    }

    @Override
    @Transactional
    public Course addCourse(Course course)
    {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course, CourseRequest courseRequest) {
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
