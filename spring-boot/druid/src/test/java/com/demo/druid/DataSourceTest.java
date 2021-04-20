package com.demo.druid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.annotation.Resource;

@SpringBootTest
public class DataSourceTest {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Test
    void jdbcTemplateTest() {
        Assertions.assertNotNull(jdbcTemplate);
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT 1 + 1");
        Assertions.assertTrue(sqlRowSet.next());
        Assertions.assertEquals("2", sqlRowSet.getString(1));
    }

}
