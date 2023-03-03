package com.jfeat.base;

import com.jfeat.crud.plus.CRUD;
import com.jfeat.module.saas.services.domain.service.TestSaasEntityService;
import com.jfeat.module.saas.services.gen.persistence.model.TestSaasEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jackyhuang
 * @date 2018/10/18
 */
public class IgnoreAuthorizationTest extends BaseJunit {

    @Autowired
    TestSaasEntityService entityEntityService;

    @Before
    public void initData(){

    }

    @Test
    public void testPost()  throws Exception {
        TestSaasEntity entity = new TestSaasEntity();
        entity.setName("testName");
        entity.setStatus("Open");
        String json = CRUD.toJSONObject(entity).toJSONString();

        var request = post("/api/crud/testsaas/entities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGet()  throws Exception {
        RequestBuilder request = get("/api/crud/testsaas/entities");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        logger.debug(result.getResponse().getContentAsString());
    }
}
