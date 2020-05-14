package com.sihan.dynamicdatasource.modules.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sihan.dynamicdatasource.config.dynamic.DataSourceManager;
import com.sihan.dynamicdatasource.config.dynamic.dto.DataSourceDTO;
import com.sihan.dynamicdatasource.modules.admin.dao.TenantDao;
import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;
import com.sihan.dynamicdatasource.modules.admin.service.TenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantServiceImpl
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@DS("master")
@Service("tenantService")
public class TenantServiceImpl extends ServiceImpl<TenantDao, TenantEntity> implements TenantService {

    @Autowired
    private DataSourceManager manager;
    @Autowired
    private TenantCreateServiceImpl tenantCreateService;

    @Override
    public TenantEntity addTenant(TenantEntity entity) {
        entity.setName(UUID.randomUUID().toString());
        entity.setUsername("postgres");
        entity.setPassword("postgres");
        entity.setDriverClassName("org.postgresql.Driver");
        baseMapper.insert(entity);
        String dbName = "tenant_" + entity.getId();
        entity.setUrl("jdbc:postgresql://127.0.0.1:5432/" + dbName);
        entity.setPoolName(dbName);

        baseMapper.updateById(entity);
        baseMapper.createTenantDatabase(entity);
        DataSourceDTO dataSourceDTO = new DataSourceDTO();
        BeanUtils.copyProperties(entity, dataSourceDTO);
        manager.add(dataSourceDTO);
        tenantCreateService.createTenantTable(dbName);
        return entity;
    }

    @Override
    public void delTenant(String id) {
        baseMapper.delTenant(id);
    }
}
