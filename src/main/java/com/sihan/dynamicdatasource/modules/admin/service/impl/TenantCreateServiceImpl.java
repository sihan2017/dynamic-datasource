package com.sihan.dynamicdatasource.modules.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sihan.dynamicdatasource.modules.admin.dao.TenantDao;
import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;
import org.springframework.stereotype.Service;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantCreateServiceImpl
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Service("tenantCreateService")
public class TenantCreateServiceImpl extends ServiceImpl<TenantDao, TenantEntity> {

    @DS("#dbName")
    public void createTenantTable(String dbName) {
        baseMapper.createTenantTable(dbName);
    }

}
