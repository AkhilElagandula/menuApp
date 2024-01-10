package com.springboot.menuapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Password Does not Match")
public class PasswordMisMatchException extends Exception{
}
