package com.gosang.mapper;

import com.gosang.entity.PersonCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
public interface PersonCourseMapper extends BaseMapper<PersonCourse> {
    int completed(Integer cid,Integer uid);
}
