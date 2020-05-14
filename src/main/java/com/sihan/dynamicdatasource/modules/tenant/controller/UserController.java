package com.sihan.dynamicdatasource.modules.tenant.controller;

import com.sihan.dynamicdatasource.modules.tenant.service.UserService;
import com.sihan.dynamicdatasource.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName UserController
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:45
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询指定租户用户信息", notes = "查询指定租户用户信息")
    @GetMapping("list")
    public R list(String poolName) {
        return R.ok().put("data", userService.list(poolName));
    }

    @ApiOperation(value = "查询主库公用数据和租户用户信息", notes = "查询主库公用数据和租户用户信息")
    @GetMapping("listWithMaster")
    public R listWithMaster(String poolName) {
        Map<String, Object> map = userService.listWithMaster(poolName);
        return R.ok().put("master", map.get("master")).put("tenant", map.get("tenant"));
    }
}
