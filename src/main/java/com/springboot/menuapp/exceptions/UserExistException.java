package com.springboot.menuapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Mobile number is already exists")
public class UserExistException extends Exception{
    private String code;
    private String message;
}
