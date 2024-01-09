package com.springboot.menuapp.menuapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody {
    private String code;
    private String message;
    private boolean flag;
}
