package com.sihan.dynamicdatasource.modules.admin.controller;

import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;
import com.sihan.dynamicdatasource.modules.admin.service.TenantService;
import com.sihan.dynamicdatasource.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantController
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:45
 **/
@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private TenantService tenantService;

    @ApiOperation(value = "租户列表", notes = "租户列表")
    @GetMapping("list")
    public R list() {
        return R.ok().put("data", tenantService.list());
    }

    @ApiOperation(value = "添加租户", notes = "添加租户")
    @GetMapping("add")
    public R add(TenantEntity entity) {

        TenantEntity tenantEntity = tenantService.addTenant(entity);
        return R.ok().put("tenant", tenantEntity);
    }

    @ApiOperation(value = "删除租户数据库", notes = "添加租户")
    @GetMapping("delete/{id}")
    public R delete(@PathVariable String id) {
        tenantService.delTenant(id);
        return R.ok();
    }

    @GetMapping("info")
    public R info(Integer id) {
        return R.ok().put("data", tenantService.getById(id));
    }
}
