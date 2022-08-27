package ro.fasttrackit.courseservice.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {
  private String discipline;
  private String description;
}
