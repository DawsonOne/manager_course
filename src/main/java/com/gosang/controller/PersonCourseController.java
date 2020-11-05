package com.gosang.controller;


import com.gosang.entity.PersonCourse;
import com.gosang.entity.User;
import com.gosang.service.PersonCourseService;
import com.gosang.util.ResultUtil;
import com.gosang.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
@RestController
@RequestMapping("//personCourse")
public class PersonCourseController {

    @Autowired
    PersonCourseService personCourseService;

    @PostMapping("/selectCourse/{courseId}")
    @ApiOperation("选课")
    public ResultVo selectCourse(@PathVariable("courseId") Integer courseId, HttpSession session){
        User user = (User)session.getAttribute("user");
        Boolean aBoolean = personCourseService.saveCourse(courseId,user);
        ResultUtil resultUtil = new ResultUtil();
        if(!aBoolean) return resultUtil.failed();
        return resultUtil.success(null);
    }

    @GetMapping("/enrollCourse")
    @ApiOperation("查看所有已选课程")
    public ResultVo enrollCourse(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<PersonCourse> personCourses = personCourseService.enrollCourseSearch(user);
        ResultUtil resultUtil = new ResultUtil();
        if(personCourses == null) return resultUtil.failed();
        return resultUtil.success(personCourses);
    }

    @PutMapping("/completed/{courseId}")
    @ApiOperation("修改课程进度状态")
    public ResultVo completed(@PathVariable("courseId") Integer courseId, HttpSession session){
        User user = (User)session.getAttribute("user");
        Boolean completed = personCourseService.completed(courseId, user);
        ResultUtil resultUtil = new ResultUtil();
        if(completed) return resultUtil.success(null);
        return resultUtil.failed();
    }

    @GetMapping("/completedCourse")
    @ApiOperation("查看所有完成课程")
    public ResultVo completedCourse(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<PersonCourse> personCourses = personCourseService.completedCourseSearch(user);
        ResultUtil resultUtil = new ResultUtil();
        if(personCourses == null) return resultUtil.failed();
        return resultUtil.success(personCourses);
    }
}

