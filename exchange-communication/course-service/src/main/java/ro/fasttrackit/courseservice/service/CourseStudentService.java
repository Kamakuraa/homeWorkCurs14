package ro.fasttrackit.courseservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.courseservice.model.entity.CourseStudent;
import ro.fasttrackit.courseservice.model.request.CourseStudentRequestDto;
import ro.fasttrackit.courseservice.model.response.CourseStudentResponseDto;
import ro.fasttrackit.courseservice.repository.CourseStudentRepository;
import ro.fasttrackit.courseservice.service.mapper.CourseStudentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
  private final CourseStudentRepository courseStudentRepository;
  private final CourseStudentMapper courseStudentMapper;

  public List<String> getAllStudentsForCourseId(String courseId) {
    List<CourseStudent> courseStudents = courseStudentRepository.findAllByCourseId(courseId);

    return courseStudents
      .stream()
      .map(CourseStudent::getStudentId)
      .collect(Collectors.toList());
  }


  public List<CourseStudent> getAllCourseStudents() {
    return courseStudentRepository.findAll();
  }


  public CourseStudentResponseDto registerStudentToCourse(String courseId,
                                                          CourseStudentRequestDto request) {
    CourseStudent courseStudent = courseStudentRepository.save(courseStudentMapper.mapCourseStudentRequestDtoToEntity(courseId, request));
    return courseStudentMapper.mapToEntityToCourseStudentResponseDto(courseStudent);
  }
}
