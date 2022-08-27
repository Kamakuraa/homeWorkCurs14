package ro.fasttrackit.studentservice.controller.exception;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(String msg) {
    super(msg);
  }
}
