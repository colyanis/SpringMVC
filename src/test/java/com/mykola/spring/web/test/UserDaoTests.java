package com.mykola.spring.web.test;


import com.mykola.spring.web.dao.User;
import com.mykola.spring.web.dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:datasource.xml",
        "classpath:config/dao-context.xml",
        "classpath:config/security-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("DELETE  from users");
    }

    @Test
    public void testCreateUser() {
        User user = new User("jedai1", "jedai", "hello", "jedai@j.com", true, "user");

        boolean result = usersDao.create(user);

        assertTrue(result);
    }
}
