package com.sihan.dynamicdatasource;

import com.sihan.dynamicdatasource.modules.admin.entity.TenantEntity;
import com.sihan.dynamicdatasource.modules.admin.service.TenantService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DynamicDatasourceApplicationTests {

    @Resource
    private MockMvc mockMvc;
    @Autowired
    private TenantService tenantService;

    @Test
    void contextLoads() {
    }

    @Test
    void createTenantTest() throws Exception {
        /*
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */
        for (int i = 1; i < 500; i++) {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/tenant/add")
                    // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        }
    }

    @Test
    void delTenantTest() throws Exception {
        for (int i = 3; i < 9; i++) {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/tenant/delete/" + i)
                    // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        }
    }

    @Test
    void createTenant() {
        for (int i = 51; i < 500; i++) {
            tenantService.addTenant(new TenantEntity());
        }
    }

    @Test
    void delTenant() {
        for (int i = 1; i < 500; i++) {
            tenantService.delTenant(String.valueOf(i));
        }
    }


    @Test
    void connectTest() throws Exception {
        for (int i = 1; i < 102; i++) {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/user/listWithMaster")
                    .param("poolName", "tenant_" + i)
                    // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        }
    }
}
