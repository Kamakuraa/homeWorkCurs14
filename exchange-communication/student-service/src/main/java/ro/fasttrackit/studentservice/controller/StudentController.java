package ro.fasttrackit.studentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.studentservice.model.StudentFilters;
import ro.fasttrackit.studentservice.model.request.StudentRequestDto;
import ro.fasttrackit.studentservice.model.response.StudentResponseDto;
import ro.fasttrackit.studentservice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;

  @GetMapping
  List<StudentResponseDto> getAll(StudentFilters filters){
    return studentService.getAllByFilters(filters);
  }

  @PostMapping
  StudentResponseDto addStudent(@RequestBody StudentRequestDto student){
    return studentService.addStudent(student);
  }

  @GetMapping("{studentId}")
  StudentResponseDto getSTudentById(@PathVariable String studentId){
    return studentService.getStudentById(studentId);
  }
  @DeleteMapping("{studentId}")
  void deleteStudentById(@PathVariable String studentId){
    studentService.deleteStudentById(studentId);
  }
}
