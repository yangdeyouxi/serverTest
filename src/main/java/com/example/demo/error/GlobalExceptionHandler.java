package com.example.demo.error;

import com.example.demo.error.entity.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//全局捕获错误的注释
@ControllerAdvice(basePackages = "com.example.demo")//括号内可以指定捕捉错误的范围
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//指定捕捉的错误类型
    @ResponseBody//将返回的结果自动插入到返回页面的body标签中
    public ErrorMessage<String> errorResult(HttpServletRequest req, Exception e){
        return handleErrorInfo(req,e.getMessage(),e);
    }

    private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
        ErrorMessage<String> errorMessage = new ErrorMessage<>();
        errorMessage.setMessage(message);
        errorMessage.setCode(ErrorMessage.ERROR);
        errorMessage.setData(message);
        errorMessage.setUrl(request.getRequestURL().toString());
        return errorMessage;
    }


}
