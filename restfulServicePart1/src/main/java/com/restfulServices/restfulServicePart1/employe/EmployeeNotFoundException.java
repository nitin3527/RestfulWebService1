package com.restfulServices.restfulServicePart1.employe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "employee with provided id is not found")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
