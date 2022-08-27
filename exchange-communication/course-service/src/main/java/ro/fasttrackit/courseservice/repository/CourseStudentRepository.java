package ro.fasttrackit.courseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.courseservice.model.entity.CourseStudent;

import java.util.List;

public interface CourseStudentRepository extends MongoRepository<CourseStudent, String> {
  List<CourseStudent> findAllByCourseId(String courseId);

  void deleteCourseStudentByStudentID(String StudentId);
}
