package com.gosang.mapper;

import com.gosang.entity.CouseMst;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
public interface CouseMstMapper extends BaseMapper<CouseMst> {
    List<CouseMst> findLikeAll(String keyword);

}
