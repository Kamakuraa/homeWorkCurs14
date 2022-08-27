package ro.fasttrackit.studentservice.model;

import lombok.Value;

@Value
public class StudentFilters {
  String name;
  String studentId;
  Integer age;
  Integer minAge;
  Integer maxAge;
}
