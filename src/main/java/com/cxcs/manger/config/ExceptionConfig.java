package com.cxcs.manger.config;

import com.cxcs.manger.vo.CommonException;
import com.cxcs.manger.vo.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse handle(Exception e){
        if(e instanceof CommonException){
            return CommonResponse.buildFailed(e.getMessage());
        }else{
            return CommonResponse.buildFailed("unknown error");
        }
    }
}
