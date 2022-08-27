package ro.fasttrackit.courseservice.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.courseservice.model.entity.CourseStudent;
import ro.fasttrackit.courseservice.model.request.CourseStudentRequestDto;
import ro.fasttrackit.courseservice.model.response.CourseStudentResponseDto;

@Service
public class CourseStudentMapper {

  public CourseStudent mapCourseStudentRequestDtoToEntity(String courseId, CourseStudentRequestDto requestDto) {
    CourseStudent courseStudent = new CourseStudent();
    courseStudent.setCourseId(courseId);
    courseStudent.setStudentId(requestDto.getStudentId());
    courseStudent.setGrade(requestDto.getGrade());

    return courseStudent;
  }

  public CourseStudentResponseDto mapToEntityToCourseStudentResponseDto(CourseStudent courseStudent) {
    CourseStudentResponseDto courseStudentResponseDto = new CourseStudentResponseDto();
    courseStudentResponseDto.setCourseStudentId(courseStudent.getCourseStudentId());
    courseStudentResponseDto.setCourseId(courseStudent.getCourseId());
    courseStudentResponseDto.setStudentId(courseStudent.getStudentId());
    courseStudentResponseDto.setGrade(courseStudent.getGrade());

    return courseStudentResponseDto;
  }
}


