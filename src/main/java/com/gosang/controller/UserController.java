package com.gosang.controller;


import com.gosang.entity.User;
import com.gosang.enums.ExceptionEnum;
import com.gosang.service.UserService;
import com.gosang.util.ResultUtil;
import com.gosang.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public ResultVo register(@RequestBody User user){
        Boolean save = userService.register(user);
        if (!save){
            throw new com.gosang.exception.UserException(ExceptionEnum.REG_FAILED);
        }
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil.success(null);
    }
    //参数或返回对象是实体类的都会被扫描到swagger中
    @PostMapping("/login")
    @ApiOperation("用户登陆")
    public ResultVo login(@RequestBody User user, HttpSession session){
        User loginUser = userService.login(user);
        ResultUtil resultUtil = new ResultUtil();
        if (loginUser == null){
            return resultUtil.failed();
        }
        session.setAttribute("user",loginUser);
        return resultUtil.success(null);
    }

    @GetMapping("/logout")
    @ApiOperation("用户登出")
    public String logout(HttpSession session) {
        session.invalidate();
        return "登出画面";
    }
}

