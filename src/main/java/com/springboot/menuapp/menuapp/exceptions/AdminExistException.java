package com.springboot.menuapp.menuapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Admin Already Exists.")
public class AdminExistException extends Exception{
}
