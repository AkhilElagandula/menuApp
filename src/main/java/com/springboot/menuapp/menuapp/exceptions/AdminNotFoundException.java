package com.springboot.menuapp.menuapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Admin Not Found.")
public class AdminNotFoundException extends Exception{
}
