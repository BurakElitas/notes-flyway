package com.burak.courseapp.api;

import com.burak.courseapp.dto.CourseRequest;
import com.burak.courseapp.dto.CourseResponse;
import com.burak.courseapp.model.Course;
import com.burak.courseapp.model.Topic;
import com.burak.courseapp.service.CourseService;
import com.burak.courseapp.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "courses",description = "Course Service")
public class CourseController extends BaseController {

    private final CourseService courseService;
    private final TopicService topicService;
    public CourseController(ModelMapper modelMapper, CourseService courseService, TopicService topicService) {
        super(modelMapper);
        this.courseService = courseService;
        this.topicService = topicService;
    }

    @RequestMapping(value = "/topics/{id}/courses",method = RequestMethod.GET)
    @ApiOperation(value = "Get all course",tags ={"courses"})
    public List<CourseResponse> getAllCourses(@PathVariable("id") Long id){
        List<Course> courses=courseService.getAllCourses(id);
        List<CourseResponse> courseResponses=mapAll(courses,CourseResponse.class);
        return courseResponses;
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}",method = RequestMethod.GET)
    @ApiOperation(value = "Get course",tags ={"courses"})
    public CourseResponse getCourse(@PathVariable("topicId") Long topicId,@PathVariable("courseId") Long courseId){
        Course course=courseService.getCourse(courseId);
        CourseResponse courseResponse=map(course,CourseResponse.class);
        return  courseResponse;
    }

    @RequestMapping(value = "/topics/{topicId}/courses",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add course",tags ={"courses"})
    public void addCourse(@RequestBody CourseRequest courseRequest, @PathVariable("topicId") Long topicId){
        Topic topic=topicService.getTopic(topicId);
        Course course=map(courseRequest,Course.class);
        course.setTopic(topic);
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update course",tags ={"courses"})
    public void updateCourse(@RequestBody CourseRequest courseRequest,@PathVariable("topicId") Long topicId,@PathVariable("courseId") Long courseId){
      Course course=courseService.getCourse(courseId);
      courseService.updateCourse(course,courseRequest);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}",method = RequestMethod.DELETE)
    @ApiOperation(value = "delete course",tags ={"courses"})
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteCourse(courseId);
    }
}
