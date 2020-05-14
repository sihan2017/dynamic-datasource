package com.sihan.dynamicdatasource.modules.tenant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sihan.dynamicdatasource.modules.tenant.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName UserDao
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    void createTenantTable(String dbName);
}
