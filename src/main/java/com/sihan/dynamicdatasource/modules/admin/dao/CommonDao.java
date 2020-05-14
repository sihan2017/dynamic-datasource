package com.sihan.dynamicdatasource.modules.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sihan.dynamicdatasource.modules.admin.entity.CommonEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName CommonDao
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Mapper
public interface CommonDao extends BaseMapper<CommonEntity> {
}
