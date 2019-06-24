package com.homecredit.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homecredit.test.entity.Module;
import com.homecredit.test.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.initUsers();
    }

    private static Map<Integer, Module> moduleMap = new HashMap<>();

    static {
        moduleMap.put(1, new Module("PromoCard", 1));
        moduleMap.put(2, new Module("CategoryCard", 2));
        moduleMap.put(3, new Module("FlashSaleCard", 3));
        moduleMap.put(4, new Module("HistoryCard", 4));
        moduleMap.put(5, new Module("NewsCard", 5));
    }

    public void initUsers() throws Exception {
        User userA = new User();
        userA.setUsername("UserA");
        userA.setModules(new ArrayList<Module>() {{
            add(moduleMap.get(1));
            add(moduleMap.get(2));
            add(moduleMap.get(3));
            add(moduleMap.get(4));
            add(moduleMap.get(5));
        }});

        User userB = new User();
        userB.setUsername("UserB");
        userB.setModules(new ArrayList<Module>() {{
            add(moduleMap.get(1));
            add(moduleMap.get(5));
            add(moduleMap.get(3));
            add(moduleMap.get(2));
            add(moduleMap.get(5));
        }});

        User userC = new User();
        userC.setUsername("UserC");
        userC.setModules(new ArrayList<Module>() {{
            add(moduleMap.get(1));
            add(moduleMap.get(3));
            add(moduleMap.get(2));
            add(moduleMap.get(5));
            add(moduleMap.get(4));
        }});
        List<User> userList = Arrays.asList(userA, userB, userC);
        this.mockMvc.perform(delete("users")).andReturn();
        MvcResult post = this.mockMvc.perform(post(URI.create("/users"))
                .contentType("application/json")
                .accept("application/json").content(mapper.writeValueAsBytes(userList)))
                .andExpect(status().isOk()).andReturn();
        log.info("Data : {}", post.getResponse().getContentAsString());
    }

    @Test
    public void getModuleUserA() throws Exception {
        MvcResult result = this.mockMvc.perform(get(URI.create("/user/modules?UserId=1")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modules[0].moduleName", equalTo(moduleMap.get(1).getModuleName())))
                .andExpect(jsonPath("$.modules[1].moduleName", equalTo(moduleMap.get(2).getModuleName())))
                .andExpect(jsonPath("$.modules[2].moduleName", equalTo(moduleMap.get(3).getModuleName())))
                .andExpect(jsonPath("$.modules[3].moduleName", equalTo(moduleMap.get(4).getModuleName())))
                .andExpect(jsonPath("$.modules[4].moduleName", equalTo(moduleMap.get(5).getModuleName())))
                .andReturn();

        log.info("Result : {}", result.getResponse().getContentAsString());
    }

}
