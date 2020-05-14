package com.sihan.dynamicdatasource.modules.tenant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sihan.dynamicdatasource.modules.tenant.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName UserService
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
public interface UserService extends IService<UserEntity> {

    List<UserEntity> list(String test);

    Map<String, Object> listWithMaster(String poolName);
}
