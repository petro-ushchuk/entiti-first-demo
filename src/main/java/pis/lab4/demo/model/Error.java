package pis.lab4.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pis.lab4.demo.model.enums.ErrorCode;
import pis.lab4.demo.model.enums.ErrorType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

  private String message;
  private ErrorCode errorCode;
  private ErrorType errorType;
  private LocalDateTime dateTime;

}
