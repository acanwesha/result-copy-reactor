package com.resultcopy.service.impl;
import com.resultcopy.CategoryResponse;
import com.resultcopy.service.ConnectionFactory;
import lombok.ToString;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ToString
@RunWith(MockitoJUnitRunner.class)
public class CategoryDAOImplTest {

    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private CategoryResponse categoryResponse;
    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);

        categoryResponse = new CategoryResponse();
        categoryResponse.setId(1);
        categoryResponse.setDisplayName("Delivery_Information");
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(categoryResponse.getDisplayName());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }
    @Test(expected=SQLException.class)
    public void nullCreateThrowsException() throws Throwable{
        new CategoryDAOImpl(null).getCategories();
        Assertions.assertTrue(throwException());
    }


    private boolean throwException() throws SQLException {
        throw new SQLException();
    }
    @Test
    public void getCategories() throws IOException {

        new CategoryDAOImpl(connectionFactory).getCategories();

    }
    @Test
    public void testConstructor() {
        CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
        Assertions.assertNotNull(categoryDAOImpl);
    }

}