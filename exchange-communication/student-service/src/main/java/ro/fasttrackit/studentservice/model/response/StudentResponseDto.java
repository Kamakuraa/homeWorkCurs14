package ro.fasttrackit.studentservice.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {
  private String studentId;
  private String name;
  private int age;
}
