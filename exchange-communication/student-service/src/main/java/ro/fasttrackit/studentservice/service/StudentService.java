package ro.fasttrackit.studentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.studentservice.controller.exception.EntityNotFoundException;
import ro.fasttrackit.studentservice.model.StudentFilters;
import ro.fasttrackit.studentservice.model.entity.Student;
import ro.fasttrackit.studentservice.model.request.StudentRequestDto;
import ro.fasttrackit.studentservice.model.response.StudentResponseDto;
import ro.fasttrackit.studentservice.repository.StudentDao;
import ro.fasttrackit.studentservice.repository.StudentRepository;
import ro.fasttrackit.studentservice.service.mapper.StudentMapper;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentMapper studentMapper;
  private final StudentDao studentDao;
  private final StudentRepository studentRepository;
  private final RabbitmqService rabbitmqService;

  public List<StudentResponseDto> getAllByFilters(StudentFilters filters) {
    return studentMapper.mapListEntityToListResponseDto(studentDao.getAll(filters));
  }

  public StudentResponseDto addStudent(StudentRequestDto request) {
    Student student = studentRepository.save(studentMapper.mapRequestDtoToEntity(request));
    return studentMapper.mapEntityToResponseDto(student);
  }


  public StudentResponseDto getStudentById(String studentId) {
    Student student = studentRepository.findById(studentId)
      .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found "));

    return studentMapper.mapEntityToResponseDto(student);
  }

  public void deleteStudentById(String studentId) {
    studentRepository.deleteById(studentId);
    rabbitmqService.notifyStudentDelete(studentId);
  }
}
