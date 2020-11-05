package com.gosang.service;

import com.gosang.entity.PersonCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gosang.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
public interface PersonCourseService extends IService<PersonCourse> {
    Boolean saveCourse(Integer courseId, User user);
    List<PersonCourse> enrollCourseSearch(User user);
    Boolean completed(Integer courseId, User user);
    List<PersonCourse> completedCourseSearch(User user);
}
