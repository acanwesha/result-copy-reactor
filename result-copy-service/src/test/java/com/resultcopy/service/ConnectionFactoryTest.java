package com.resultcopy.service;

import com.resultcopy.service.impl.ChildDAOImpl;
import lombok.ToString;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ToString
@RunWith(MockitoJUnitRunner.class)
public class ConnectionFactoryTest {
    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private DriverManager driverManager;
    @Mock
    private ConnectionFactory mock;
    @Test
    public void testConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/maternity";
        String USER = "root";
        String PASS = "root";
        Connection connection = connectionFactory.getConnection();
        Assertions.assertEquals(driverManager.getConnection(URL,USER,PASS).getClass(),connection.getClass());
    }

    @Test(expected=RuntimeException.class)
    public void testCatchStatement(){
        Mockito.mock(ConnectionFactory.class);
        when(ConnectionFactory.getConnection())
                .thenThrow(new RuntimeException("Error connecting to the database"));
    }

}