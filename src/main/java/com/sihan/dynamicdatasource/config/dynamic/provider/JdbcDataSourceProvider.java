package com.sihan.dynamicdatasource.config.dynamic.provider;

import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 从数据库中加载数据源
 *
 * @author zhouj
 * @version 1.0.0
 * @ClassName JdbcSourceProvider
 * @email zhoujdev@163.com
 * @date 2020/5/14 11:46
 **/
@Slf4j
public class JdbcDataSourceProvider extends AbstractJdbcDataSourceProvider implements DynamicDataSourceProvider {
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public JdbcDataSourceProvider(String driverClassName, String url, String username, String password) {
        super(driverClassName, url, username, password);
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
        Map<String, DataSourceProperty> map = new HashMap<>();

        // 先将主库放入
        DataSourceProperty propertyMaster = new DataSourceProperty();
        propertyMaster.setUsername(this.username);
        propertyMaster.setPassword(this.password);
        propertyMaster.setUrl(this.url);
        propertyMaster.setDriverClassName(this.driverClassName);
        map.put("master", propertyMaster);

        ResultSet rs = statement.executeQuery("select * from tenant");
        while (rs.next()) {
            String name = rs.getString("pool_name");
            String url = rs.getString("url");
            String driver = rs.getString("driver_class_name");
            String username = rs.getString("username");
            String password = rs.getString("password");
            DataSourceProperty property = new DataSourceProperty();
            property.setUsername(username);
            property.setPassword(password);
            property.setUrl(url);
            property.setDriverClassName(driver);
            map.put(name, property);
        }
        log.info(String.format("dynamic-datasource - load %s datasource from database", (map.size() - 1)));
        return map;
    }
}
