package com.gosang.service.impl;

import com.gosang.entity.CouseMst;
import com.gosang.mapper.CouseMstMapper;
import com.gosang.service.CouseMstService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CouseMstServiceImpl extends ServiceImpl<CouseMstMapper, CouseMst> implements CouseMstService {

    @Autowired
    CouseMstMapper couseMstMapper;

    @Override
    public List<CouseMst> findLikeAll(String keyword) {
        return couseMstMapper.findLikeAll(keyword);

    }
}
