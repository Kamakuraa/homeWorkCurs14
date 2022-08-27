package ro.fasttrackit.courseservice.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseStudentResponseDto {
  private String courseStudentId;
  private String courseId;
  private String studentId;
  private int grade;
}
