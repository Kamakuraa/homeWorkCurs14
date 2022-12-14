package ro.fasttrackit.courseservice.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {
  private String courseId;
  private String discipline;
  private String description;
}
