package com.integrationabdi.springintegrationtesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class StudentNotFoundException extends RuntimeException {
}
