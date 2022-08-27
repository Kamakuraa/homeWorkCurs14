package ro.fasttrackit.courseservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.courseservice.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.courseservice.model.entity.Course;
import ro.fasttrackit.courseservice.model.request.CourseRequestDto;
import ro.fasttrackit.courseservice.model.response.CourseResponseDto;
import ro.fasttrackit.courseservice.repository.CoursesRepository;
import ro.fasttrackit.courseservice.service.mapper.CourseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
  private final CoursesRepository coursesRepository;
  private final CourseMapper courseMapper;

  public List<CourseResponseDto> getAll() {
    return courseMapper.mapEntityListToResponseDto(coursesRepository.findAll());
  }

  public CourseResponseDto addCourse(CourseRequestDto request) {
    Course course = coursesRepository.save(courseMapper.mapRequestDtoToEntity(request));
    return courseMapper.mapEntityToResponseDto(course);
  }

  public CourseResponseDto getCourseById(String courseId) {
    Course course = coursesRepository.findById(courseId)
      .orElseThrow(() -> new EntityNotFoundException("course with id " + courseId + " not found "));
    return courseMapper.mapEntityToResponseDto(course);
  }
}
