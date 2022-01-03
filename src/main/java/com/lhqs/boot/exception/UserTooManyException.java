package com.lhqs.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
* 自定义异常，发生这个异常，将状态码作为字符串返回给异常解析器，
* */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException(String message) {
        super(message);
    }

    public UserTooManyException() {
    }
}
