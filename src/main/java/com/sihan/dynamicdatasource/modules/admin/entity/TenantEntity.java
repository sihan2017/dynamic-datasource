package com.sihan.dynamicdatasource.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName TenantEntity
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Data
@TableName("tenant")
public class TenantEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String name;
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String poolName;
}
