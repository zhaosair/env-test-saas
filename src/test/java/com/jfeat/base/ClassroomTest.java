package com.jfeat.base;

import com.jfeat.AmApplication;
import com.jfeat.am.module.test.api.ClassroomOverModelEndpoint;
import com.jfeat.am.module.test.services.domain.service.TestSaasEntityService;
import com.jfeat.am.module.test.services.gen.persistence.model.Classroom;
import com.jfeat.am.module.test.services.gen.persistence.model.TestSaasEntity;
import com.jfeat.crud.plus.CRUD;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={AmApplication.class})
public class ClassroomTest extends BaseJunit{

    @Autowired
    ClassroomOverModelEndpoint classroomOverModelEndpoint;

    @Before
    public void initData(){

    }

    @Test
    public void testCreatePost() throws Exception{
        Classroom classroom = new Classroom();
        classroom.setName("二年级二班");
        String json = CRUD.toJSONObject(classroom).toJSONString();
        var request = post("/api/crud/test/classroom/classrooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetClassroomById() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/crud/test/classroom/classrooms")
                .param("id","1"))
                .andReturn();
        logger.debug(result.getResponse().getContentAsString());

    }

    @Test
    public void testGet()  throws Exception {
        RequestBuilder request = get("/api/crud/test/classroom/classrooms");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        logger.debug(result.getResponse().getContentAsString());
    }
}
