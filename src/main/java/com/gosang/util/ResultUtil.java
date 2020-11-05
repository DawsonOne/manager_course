package com.gosang.util;

import com.gosang.vo.ResultVo;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/4 12:27
 */
public class ResultUtil {

    public ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    public ResultVo failed(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(-1);
        resultVo.setMsg("失败");
        return resultVo;
    }

}
