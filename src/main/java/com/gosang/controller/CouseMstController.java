package com.gosang.controller;


import com.gosang.entity.CouseMst;
import com.gosang.service.CouseMstService;
import com.gosang.util.ResultUtil;
import com.gosang.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("//couseMst")
public class CouseMstController {

    @Autowired
    CouseMstService couseMstService;

    @GetMapping("/courseSearch/{keyWord}")
    @ApiOperation("根据关键词搜索课程")
    public ResultVo courseSearch(@PathVariable("keyWord") String keyword){
        List<CouseMst> courseList = couseMstService.findLikeAll(keyword);
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil.success(courseList);
    }

    @GetMapping("/courseSearch/{keyWord}")
    @ApiOperation("瞎写一个")
    public ResultVo courseSearch1(@PathVariable("keyWord") String keyword){
        List<CouseMst> courseList = couseMstService.findLikeAll(keyword);
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil.success(courseList);
    }
}

