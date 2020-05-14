package com.sihan.dynamicdatasource.modules.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantService
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
public interface TenantService extends IService<TenantEntity> {
    TenantEntity addTenant(TenantEntity entity);

    void delTenant(String id);
}
