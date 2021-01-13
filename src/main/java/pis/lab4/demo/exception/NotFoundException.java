package pis.lab4.demo.exception;

import pis.lab4.demo.model.enums.ErrorCode;
import pis.lab4.demo.model.enums.ErrorType;

public class NotFoundException extends AbstractException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
