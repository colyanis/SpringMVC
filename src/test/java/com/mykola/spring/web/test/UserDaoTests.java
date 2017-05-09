package com.mykola.spring.web.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:datasource.xml",
        "classpath:config/dao-context.xml",
        "classpath:config/security-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
    @Test
    public void testCreateUser() {
         assertEquals("Dummy test", 1, 1);
    }
}
