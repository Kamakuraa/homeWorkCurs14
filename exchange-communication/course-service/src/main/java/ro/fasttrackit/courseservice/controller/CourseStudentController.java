package ro.fasttrackit.courseservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.courseservice.model.entity.CourseStudent;
import ro.fasttrackit.courseservice.model.request.CourseStudentRequestDto;
import ro.fasttrackit.courseservice.model.response.CourseStudentResponseDto;
import ro.fasttrackit.courseservice.service.CourseStudentService;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class CourseStudentController {
  private final CourseStudentService courseStudentService;

  @GetMapping("/students")
  List<CourseStudent> getAllCourseStudent(){
    return courseStudentService.getAllCourseStudents();
  }
  @GetMapping("{courseId}/students")
  List<String> getAllStudentsForCourseId(@PathVariable String courseId){
    return courseStudentService.getAllStudentsForCourseId(courseId);
  }
  @PostMapping("{courseId}/students")
  CourseStudentResponseDto registerStudentToCourse(@PathVariable String courseId,
                                                   @RequestBody CourseStudentRequestDto request){
    return courseStudentService.registerStudentToCourse(courseId, request);
  }

}
