package com.gosang.service;

import com.gosang.entity.CouseMst;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
public interface CouseMstService extends IService<CouseMst> {
    List<CouseMst> findLikeAll(String keyword);
}
