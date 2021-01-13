package pis.lab4.demo.exception;

import pis.lab4.demo.model.enums.ErrorCode;
import pis.lab4.demo.model.enums.ErrorType;

public abstract class AbstractException extends RuntimeException {

  public AbstractException(String message) {
    super(message);
  }

  public AbstractException(String message, Throwable cause) {
    super(message, cause);
  }

  public ErrorCode getErrorCode() {
    return ErrorCode.APPLICATION_ERROR_CODE;
  }

  public ErrorType getErrorType() {
    return ErrorType.FATAL_ERROR_TYPE;
  }

}
