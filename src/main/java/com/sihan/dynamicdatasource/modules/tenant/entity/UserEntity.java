package com.sihan.dynamicdatasource.modules.tenant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName UserEntity
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:46
 **/
@Data
@TableName("t_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String username;
}
