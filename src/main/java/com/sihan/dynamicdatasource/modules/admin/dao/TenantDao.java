package com.sihan.dynamicdatasource.modules.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantDao
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Mapper
public interface TenantDao extends BaseMapper<TenantEntity> {
    void createTenantDatabase(TenantEntity entity);


    void createTenantTable(@Param("dbName") String dbName);

    void delTenant(@Param("id") String id);
}
