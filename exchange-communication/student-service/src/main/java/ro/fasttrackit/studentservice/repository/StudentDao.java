package ro.fasttrackit.studentservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.studentservice.model.StudentFilters;
import ro.fasttrackit.studentservice.model.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDao {
  private final MongoTemplate mongo;

  public List<Student> getAll(StudentFilters filters){
    Criteria studentCriteria = getStudentCriteria(filters);
    return getStudents(studentCriteria);
  }

  private List<Student> getStudents(Criteria studentCriteria) {
    Query studentQuery = new Query(studentCriteria);
    return mongo.find(studentQuery, Student.class);
  }

  private Criteria getStudentCriteria(StudentFilters filters) {
    Criteria studentCriteria = new Criteria();

    Optional.ofNullable(filters.getName())
      .ifPresent(name-> studentCriteria.and("name").is(name));

    Optional.ofNullable(filters.getStudentId())
      .ifPresent(studentId -> studentCriteria.and("studentId").is(studentId));

    Optional.ofNullable(filters.getAge())
      .ifPresent(age -> studentCriteria.and("age").is(age));

    Optional.ofNullable(filters.getMinAge())
      .ifPresent(minAge -> studentCriteria.and("age").gt(minAge));

    Optional.ofNullable(filters.getMaxAge())
      .ifPresent(maxAge -> studentCriteria.and("age").lt(maxAge));

    return studentCriteria;
  }

}
