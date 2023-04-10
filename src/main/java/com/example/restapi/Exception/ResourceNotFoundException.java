package com.example.restapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private  String resourcename;
    private  String firstname;
    private  Object fieldValue;
    public ResourceNotFoundException(String resourcename, String firstname, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'" , resourcename , firstname , fieldValue));
        this.resourcename = resourcename;
        this.firstname = firstname;
        this.fieldValue = fieldValue;
    }
}
