package com.lanierblack.controller;

import com.lanierblack.common.Constant;
import com.lanierblack.common.CustomException;
import com.lanierblack.util.ResponseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseModel defaultException(HttpServletRequest request, Exception e){
        return new ResponseModel(Constant.ERROR, "服务未找到, 请检查URL: "+request.getRequestURL().toString());
    }

    @ExceptionHandler(Exception.class)
    public ResponseModel handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        //如果是自定义的异常，返回对应的错误信息
        String errMsg = null;
        if (e instanceof CustomException) {
            CustomException exception = (CustomException) e;
            errMsg = exception.getMsg();

        } else if (e instanceof HttpMediaTypeNotSupportedException){
            errMsg = e.getMessage();
        } else if (e instanceof NoHandlerFoundException) {
            errMsg = "default error";
        } else {
            //如果不是已知异常，返回系统异常
            if(response.getStatus() != 404){
                errMsg = "系统异常, 请重试!";
            }else {
                errMsg = "您访问URL:"+request.getRequestURL().toString()+"不存在!";
            }
        }
        return new ResponseModel(Constant.ERROR, errMsg);
    }

}
