package com.gosang.vo;

import lombok.Data;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/4 12:24
 */
@Data
public class ResultVo<K> {
    public Integer code;
    public String msg;
    public K data;
}
