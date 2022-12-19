package com.example.exception;

import com.example.domain.Result;
import com.example.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
@RestControllerAdvice
public class ExpectionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyException.class);


    @ExceptionHandler(value = Exception.class)
    public  Result<String> handler(Exception e) {
        if (e instanceof MyException) {
            return new Result<>(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMessage(), "-100");
        } else {
            return new Result<>(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMessage(), "-2");
        }
    }

}
