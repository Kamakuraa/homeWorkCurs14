package ro.fasttrackit.studentservice.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection= "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  @Id
  public String studentId;
  @NonNull
  private String name;
  @NonNull
  private int age;

}
