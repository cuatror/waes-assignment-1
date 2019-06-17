package com.waes.assignment.rest.exception;

import com.waes.assigment.domain.enums.MessageCodeEnum;
import com.waes.assigment.domain.exception.BusinessException;
import com.waes.assignment.rest.DiffController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = DiffController.class)
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException exception) {
        if (exception.getMessage().equals(MessageCodeEnum.ERROR_DECODE_DATA)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

        if (exception.getMessage().equals(MessageCodeEnum.DATA_NOT_BASE64)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(exception.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }


}
