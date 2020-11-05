package com.gosang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gosang.entity.CouseMst;
import com.gosang.entity.PersonCourse;
import com.gosang.entity.User;
import com.gosang.mapper.CouseMstMapper;
import com.gosang.mapper.PersonCourseMapper;
import com.gosang.service.PersonCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gosang.vo.CourseMstTranseferPersonCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
@Service
public class PersonCourseServiceImpl extends ServiceImpl<PersonCourseMapper, PersonCourse> implements PersonCourseService {

    @Autowired
    PersonCourseMapper personCourseMapper;

    @Autowired
    CouseMstMapper couseMstMapper;

    @Override
    public Boolean saveCourse(Integer courseId, User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cid",courseId);
        CouseMst couseMst = couseMstMapper.selectOne(queryWrapper);
        CourseMstTranseferPersonCourse trn = new CourseMstTranseferPersonCourse();
        PersonCourse personCourse = trn.tansefer(couseMst);
        //0代表已选课程但未完成
        personCourse.setMcFlag("0");
        personCourse.setUsrId(user.getId());
        int insert = personCourseMapper.insert(personCourse);
        if (insert == 1){
            return true;
        }
        return false;
    }


    @Override
    public List<PersonCourse> enrollCourseSearch(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("usr_id",user.getId());
        queryWrapper.eq("mc_flag","0");
        List<PersonCourse> list = personCourseMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public Boolean completed(Integer courseId, User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("mc_id",courseId);
        queryWrapper.eq("usr_id",user.getId());
        int completed = personCourseMapper.completed(courseId, user.getId());
        if (completed ==1) return true;
        return false;
    }

    @Override
    public List<PersonCourse> completedCourseSearch(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("usr_id",user.getId());
        queryWrapper.eq("mc_flag","1");
        List<PersonCourse> list = personCourseMapper.selectList(queryWrapper);
        return list;
    }
}
