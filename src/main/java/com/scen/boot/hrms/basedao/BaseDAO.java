package com.scen.boot.hrms.basedao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的mapper
 *
 * @author Scen
 * @date 2018/7/16 9:56
 */
public interface BaseDAO<T> extends Mapper<T>, MySqlMapper<T> {
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
