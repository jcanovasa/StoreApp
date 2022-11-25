package com.javaschool.project.exceptions;

import com.javaschool.project.models.User;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
