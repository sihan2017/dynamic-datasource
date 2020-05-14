package com.sihan.dynamicdatasource.modules.admin.controller;

import com.sihan.dynamicdatasource.modules.admin.service.CommonService;
import com.sihan.dynamicdatasource.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName CommonController
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:45
 **/
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @GetMapping("list")
    public R list() {
        return R.ok().put("data", commonService.list());
    }
}
