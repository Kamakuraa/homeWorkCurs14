package ro.fasttrackit.studentservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.studentservice.model.entity.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
