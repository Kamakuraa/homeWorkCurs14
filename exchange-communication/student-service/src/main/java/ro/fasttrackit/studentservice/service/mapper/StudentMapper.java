package ro.fasttrackit.studentservice.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.studentservice.model.entity.Student;
import ro.fasttrackit.studentservice.model.request.StudentRequestDto;
import ro.fasttrackit.studentservice.model.response.StudentResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMapper {
  public List<StudentResponseDto> mapListEntityToListResponseDto(List<Student> entities){
    return entities.stream()
      .map(this::mapEntityToResponseDto)
      .collect(Collectors.toList());
  }

  public StudentResponseDto mapEntityToResponseDto(Student entity) {
    StudentResponseDto studentResponseDto = new StudentResponseDto();
    studentResponseDto.setStudentId(entity.getStudentId());
    studentResponseDto.setName(entity.getName());
    studentResponseDto.setAge(entity.getAge());

    return studentResponseDto;
  }

  public Student mapRequestDtoToEntity(StudentRequestDto request){
    Student student = new Student();
    student.setStudentId(request.getName());
    student.setAge(request.getAge());

    return student;
  }
}
