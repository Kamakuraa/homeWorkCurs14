package ro.fasttrackit.courseservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.courseservice.model.request.CourseRequestDto;
import ro.fasttrackit.courseservice.model.response.CourseResponseDto;
import ro.fasttrackit.courseservice.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
  private final CourseService courseService;

  @GetMapping
  List<CourseResponseDto> getAll(){
    return courseService.getAll();
  }

  @PostMapping
  CourseResponseDto addCourse(@RequestBody CourseRequestDto course){
    return courseService.addCourse(course);
  }
  @GetMapping("{courseId}")
  CourseResponseDto getCourseById(@PathVariable String courseId){
    return courseService.getCourseById(courseId);
  }
}
