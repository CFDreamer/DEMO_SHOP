package com.mapper;

import com.entity.SuperType;

/**
 * 商品类别表的mapper
 * @author 陈小锋
 *
 */
public interface SyperTypeMapper {
    /**
     * 根据类型的id查询类型名字
     */
	public SuperType selectSupertype(Integer id) ;
}
