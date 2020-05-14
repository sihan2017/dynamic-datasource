package com.sihan.dynamicdatasource.config.dynamic;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.sihan.dynamicdatasource.config.dynamic.provider.JdbcDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author zhouj
 * @version 1.0.0
 * @ClassName MybatisPlusConfiguration
 * @email zhoujdev@163.com
 * @date 2020/5/13 15:49
 **/
@Configuration
public class MybatisPlusConfiguration {

    @Autowired
    private DynamicDataSourceProperties pros;

    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    public DynamicDataSourceProvider dynamicDataSourceProvider() {
        DataSourceProperty master = pros.getDatasource().get("master");
        return new JdbcDataSourceProvider(master.getDriverClassName(), master.getUrl(), master.getUsername(), master.getPassword());
    }
}
