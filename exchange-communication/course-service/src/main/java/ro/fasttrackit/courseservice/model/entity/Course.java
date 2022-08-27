package ro.fasttrackit.courseservice.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Inherited;

@Data
@Document(collation = "courses")
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Course {
  @Id
  private String courseId;
  @NonNull
  private String discipline;
  @NonNull
  private String description;
}
