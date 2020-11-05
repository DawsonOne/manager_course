package com.gosang.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/3 21:50
 */
@Getter
public enum ExceptionEnum {

    USR_NULL(0,"用户为空"),
    REG_FAILED(1,"注册失败"),
    LOGIN_FAILED(2,"登陆失败");

    @EnumValue
    public Integer code;
    public String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
