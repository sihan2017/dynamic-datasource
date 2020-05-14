package com.sihan.dynamicdatasource.config.dynamic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 数据库连接参数映射
 *
 * @author zhouj
 * @version 1.0.0
 * @ClassName DataSourceDTO
 * @email zhoujdev@163.com
 * @date 2020/5/14 9:38
 **/
@Data
public class DataSourceDTO {

    /**
     * 连接池名称
     */
    @NotBlank
    private String poolName;

    /**
     * JDBC driver
     */
    @NotBlank
    private String driverClassName;

    /**
     * JDBC url 地址
     */
    @NotBlank
    private String url;

    /**
     * JDBC 用户名
     */
    @NotBlank
    private String username;

    /**
     * JDBC 密码
     */
    private String password;

}
