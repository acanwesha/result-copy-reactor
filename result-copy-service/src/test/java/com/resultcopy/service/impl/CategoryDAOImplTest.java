package com.resultcopy.service.impl;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.resultcopy.CategoryResponse;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.ResultResponse;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Mock
    private CategoryDAOImpl mock;
    @Mock
    private CategoryResponse categoryResponses;

    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
    }

    @Test
    public void testCategoryDAOImpl() throws SQLException {
        CategoryResponse categoryResponse = new CategoryResponse();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        categoryResponse.setId(12);
        categoryResponse.setDisplayName("DELIVERY_INFORMATION");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(categoryResponse.getId());
        when(resultSet.getString(2)).thenReturn(categoryResponse.getDisplayName());

        categoryResponses = new CategoryResponse();
        categoryResponses.setId(resultSet.getInt(1));
        categoryResponses.setDisplayName(resultSet.getString(2));
        categoryResponseList.add(categoryResponses);

        mock = org.mockito.Mockito.mock(CategoryDAOImpl.class);
        when(mock.getCategories()).thenReturn(categoryResponseList);

        List<CategoryResponse> categoryResponseList1 = new CategoryDAOImpl(connectionFactory).getCategories();

        Assertions.assertEquals(categoryResponses.getDisplayName(),categoryResponseList1.listIterator().next().getDisplayName());
    }
    @Test
    public void testConstructor() {
        CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
        Assertions.assertNotNull(categoryDAOImpl);
    }

}