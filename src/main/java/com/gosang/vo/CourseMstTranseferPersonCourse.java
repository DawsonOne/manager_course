package com.gosang.vo;

import com.gosang.entity.CouseMst;
import com.gosang.entity.PersonCourse;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/4 14:54
 */
public class CourseMstTranseferPersonCourse {
    public PersonCourse tansefer(CouseMst couseMst){
        PersonCourse personCourse = new PersonCourse();
        personCourse.setMcId(couseMst.getCid());
        personCourse.setMcName(couseMst.getCname());
        return personCourse;
    }
}
