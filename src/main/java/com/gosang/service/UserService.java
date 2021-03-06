package com.gosang.service;

import com.gosang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
public interface UserService extends IService<User> {
    Boolean register(User user);
    User login(User user);

}
