package ro.fasttrackit.courseservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.fasttrackit.courseservice.repository.CourseStudentRepository;
import ro.fasttrackit.tema12.model.StudentDeleteEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriberListener {
  private final CourseStudentRepository courseStudentRepository;

  @RabbitListener(queues = "#{fanoutQueue.name}")
  void fanoutListener(StudentDeleteEvent event){
    log.info("delete Student Courses by studentId: " + event.getStudentId());
  }
}
