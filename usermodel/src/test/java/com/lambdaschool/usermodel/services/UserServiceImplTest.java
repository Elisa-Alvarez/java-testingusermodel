package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import io.restassured.mapper.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
public class UserServiceImplTest
{

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        List<User> myList = userService.findAll();
        for (User u : myList)
        {
            System.out.println(u.getUserid() + " " + u.getUsername());
        }
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findUserById()
    {
        assertEquals("Test barnbarn", userService.findUserById(1).getUsername());
    }

    @Test
    public void findByNameContaining()
    {
        assertEquals(1, userService.findByNameContaining("Test stumps").size());
    }

    @Test
    public void findAll()
    {

    }

    @Test
    public void delete()
    {
        userService.delete(2);
        assertEquals(2, userService.findAll().size());
    }

    @Test
    public void findByName()
    {
        assertEquals ("Test misskitty", userService.findByName("Test misskitty").getUsername());
    }

    @Test
    public void save()
    {
        User nu = new User("Elisa", "Ilovepizza", "pizzalove5000@pizza.com");
        userService.save(nu);
        assertEquals(6, userService.findAll().size());
    }

    @Test
    public void update()
    {
        User up = new User("Elisa2", "pizzasucks", "ihatepizza@pizzahate.com");
        userService.update(up, 7);
        assertEquals("elisa2", userService.findUserById(7).getUsername());
        assertEquals("pizzasucks", userService.findUserById(7).getPassword());
    }

    @Test
    public void deleteAll()
    {
        userService.deleteAll();
        assertEquals(0, userService.findAll().size());
    }
}