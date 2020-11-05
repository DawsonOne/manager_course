package com.gosang.exception;

import com.gosang.enums.ExceptionEnum;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/3 21:48
 */
public class UserException extends RuntimeException{
    public UserException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
    }
}
