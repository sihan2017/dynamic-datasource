package com.sihan.dynamicdatasource.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * 分页工具类
 *
 * @author zhoujian
 * @version 1.0.0
 * @ClassName PageUtil
 * @date 2019-06-27 09:44
 **/
public class PageUtil {

    public static Page initPage(Page page, Map<String, Object> params) {
        Object current = params.get("page");
        Object size = params.get("limit");
        if (current != null)
            page.setCurrent(Long.valueOf(String.valueOf(current)));
        if (size != null)
            page.setSize(Long.valueOf(String.valueOf(size)));
        return page;
    }
}