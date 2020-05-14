package com.sihan.dynamicdatasource.modules.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sihan.dynamicdatasource.modules.admin.dao.CommonDao;
import com.sihan.dynamicdatasource.modules.admin.entity.CommonEntity;
import com.sihan.dynamicdatasource.modules.admin.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName CommonServiceImpl
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@DS("master")
@Service
public class CommonServiceImpl extends ServiceImpl<CommonDao, CommonEntity> implements CommonService {

}
