package com.anz.wholesaleapp.exception;

import com.anz.wholesaleapp.api.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class WaExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(WaExceptionHandler.class);

  @ExceptionHandler({DataNotFoundException.class})
  public ResponseEntity<ApiError> handleNoDataFoundException(DataNotFoundException dataNotFoundException, HttpServletRequest httpServletRequest) {
    logger.error("exception occurred = ", dataNotFoundException);
    return new ResponseEntity<>(dataNotFoundException.getApiError(), HttpStatus.BAD_REQUEST);
  }
}
