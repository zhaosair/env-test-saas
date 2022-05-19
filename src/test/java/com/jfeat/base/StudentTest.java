package com.jfeat.base;

import com.jfeat.AmApplication;
import com.jfeat.am.module.test.api.ClassroomOverModelEndpoint;
import com.jfeat.am.module.test.api.StudentOverModelEndpoint;
import com.jfeat.am.module.test.services.gen.persistence.model.Classroom;
import com.jfeat.am.module.test.services.gen.persistence.model.Student;
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
public class StudentTest extends BaseJunit{
    @Autowired
    StudentOverModelEndpoint studentOverModelEndpoint;

    @Before
    public void initData(){

    }

    @Test
    public void testCreatePost() throws Exception{
        Student student = new Student();
        student.setName("小红");
        student.setAddress("广东");
        String json = CRUD.toJSONObject(student).toJSONString();
        var request = post("/api/crud/test/student/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        logger.debug(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetStudentdById() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/crud/test/student/students")
                .param("id","1"))
                .andReturn();
        logger.debug(result.getResponse().getContentAsString());

    }

    @Test
    public void testGet()  throws Exception {
        RequestBuilder request = get("/api/crud/test/student/students");
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
        logger.debug(result.getResponse().getContentAsString());
    }

    public void testQueryStudentPage() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/crud/test/student/students")
                .param("pageNum","1"))
                .andReturn();
        logger.debug(result.getResponse().getContentAsString());
    }

}
