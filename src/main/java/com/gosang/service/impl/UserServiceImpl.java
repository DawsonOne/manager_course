package com.gosang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gosang.entity.User;
import com.gosang.enums.ExceptionEnum;
import com.gosang.mapper.UserMapper;
import com.gosang.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean register(User user) {
        if (user == null){
            throw new com.gosang.exception.UserException(ExceptionEnum.USR_NULL);
        }
        int result = userMapper.insert(user);
        if (result == 1){
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        if (user == null){
            throw new com.gosang.exception.UserException(ExceptionEnum.USR_NULL);
        }
        QueryWrapper wra = new QueryWrapper();
        wra.eq("uname",user.getUname());
        wra.eq("upwd",user.getUpwd());
        User user1 = userMapper.selectOne(wra);
        return user1;
    }
}
