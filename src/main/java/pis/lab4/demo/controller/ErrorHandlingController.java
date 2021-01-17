package pis.lab4.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import pis.lab4.demo.exception.AbstractException;
import pis.lab4.demo.exception.NotFoundException;
import pis.lab4.demo.model.enums.ErrorCode;
import pis.lab4.demo.model.enums.ErrorType;
import pis.lab4.demo.model.Error;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    log.error("handleMethodArgumentNotValidException: exception {}", ex.getMessage());
    return ex.getBindingResult().getAllErrors().stream()
        .map(err -> new Error(err.getDefaultMessage(), ErrorCode.VALIDATION_ERROR_CODE,
            ErrorType.PROCESSING_ERROR_TYPE, LocalDateTime.now()))
        .collect(Collectors.toList());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleAbstractNotFoundException(NotFoundException ex, HandlerMethod hm) {
    log.error("handleAbstractException: exception {}, method {}",
            ex.getMessage(), hm.getMethod().getName());
    return new Error(ex.getMessage(),ErrorCode.NOT_FOUND , ErrorType.PROCESSING_ERROR_TYPE, LocalDateTime.now());
  }

  @ExceptionHandler(AbstractException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleAbstractException(AbstractException ex, HandlerMethod hm) {
    log.error("handleAbstractException: exception {}, method {}",
            ex.getMessage(), hm.getMethod().getName(), ex);
    return new Error(ex.getMessage(), ex.getErrorCode(), ex.getErrorType(), LocalDateTime.now());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleAllException(Exception ex, HandlerMethod hm) {
    log.error("handleAllException: exception {}, method {}",
        ex.getMessage(), hm.getMethod().getName(), ex);
    return new Error(ex.getMessage(), ErrorCode.APPLICATION_ERROR_CODE, ErrorType.FATAL_ERROR_TYPE,
        LocalDateTime.now());
  }

}
