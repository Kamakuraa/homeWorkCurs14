package ro.fasttrackit.courseservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.courseservice.model.entity.Course;

public interface CoursesRepository extends MongoRepository<Course, String> {
  Course findByCourseId(String courseId);
}
