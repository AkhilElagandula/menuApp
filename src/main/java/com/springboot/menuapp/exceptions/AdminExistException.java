package com.springboot.menuapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Admin Already Exists.")
public class AdminExistException extends Exception{
    private String code;
    private String message;
}
