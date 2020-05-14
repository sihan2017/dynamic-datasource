package com.sihan.dynamicdatasource.modules.tenant.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sihan.dynamicdatasource.modules.admin.service.CommonService;
import com.sihan.dynamicdatasource.modules.tenant.dao.UserDao;
import com.sihan.dynamicdatasource.modules.tenant.entity.UserEntity;
import com.sihan.dynamicdatasource.modules.tenant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName UserServiceImpl
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private CommonService commonService;

    @Override
    @DS("#poolName")
    public List<UserEntity> list(String poolName) {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("#poolName")
    public Map<String, Object> listWithMaster(String poolName) {
        Map<String, Object> map = new HashMap<>();
        map.put("master", commonService.list(null));
        map.put("tenant", baseMapper.selectList(null));
        return map;
    }

}
