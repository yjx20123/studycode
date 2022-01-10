package com.yang;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {

        Connection connection = dataSource.getConnection();
        connection.close();

    }

}
