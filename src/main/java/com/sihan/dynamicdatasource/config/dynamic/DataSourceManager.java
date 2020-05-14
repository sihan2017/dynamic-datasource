package com.sihan.dynamicdatasource.config.dynamic;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.sihan.dynamicdatasource.config.dynamic.dto.DataSourceDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Set;

/**
 * 数据源管理
 *
 * @author zhouj
 * @version 1.0.0
 * @ClassName DynamicDataSourceManager
 * @email zhoujdev@163.com
 * @date 2020/5/14 9:38
 **/
@Component
@AllArgsConstructor
public class DataSourceManager {

    private final DataSource dataSource;
    private final DataSourceCreator dataSourceCreator;

    public Set<String> list() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        return ds.getCurrentDataSources().keySet();
    }

    public Set<String> add(DataSourceDTO dto) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        BeanUtils.copyProperties(dto, dataSourceProperty);
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(dto.getPoolName(), dataSource);
        return ds.getCurrentDataSources().keySet();
    }


    public String remove(String name) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(name);
        return "删除成功";
    }
}
