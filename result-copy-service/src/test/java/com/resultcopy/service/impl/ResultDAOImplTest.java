package com.resultcopy.service.impl;
import com.resultcopy.CategoryResponse;
import com.resultcopy.ChildResultResponse;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


@ToString
@RunWith(MockitoJUnitRunner.class)
public class ResultDAOImplTest {
    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private ResultResponse resultResponse;
    @Mock
    private ChildResultResponse patientResult;
    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
        resultResponse = new ResultResponse();
        resultResponse.setId(1);
        resultResponse.setDisplayName("Pregnancy_Outcome");
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(resultResponse.getDisplayName());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }
    @Test(expected=SQLException.class)
    public void nullCreateThrowsException() throws Throwable{
        new ResultDAOImpl(null).getCategories(2);
        Assertions.assertTrue(throwException());
    }
    private boolean throwException() throws SQLException {
        throw new SQLException();
    }
    @Test
    public void getCategories() {
        new ResultDAOImpl(connectionFactory).getCategories(12);
    }
    @BeforeEach
    void setUpChild() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
        patientResult=new ChildResultResponse();
        patientResult.setChildId(32);
        patientResult.setValue("Vaginal_birth");
        patientResult.setResultId(2);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(32);
        when(resultSet.getString(2)).thenReturn(patientResult.getValue());
        when(resultSet.getInt(3)).thenReturn(2);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

    }
    @Test
    public void getChildValueById(){

        new ResultDAOImpl(connectionFactory).getChildValueById(12);
    }

    @Test(expected=SQLException.class)
    public void nullCreateChildThrowsException() throws Throwable{
        new ResultDAOImpl(null).getChildValueById(2);
        Assertions.assertTrue(throwException());
    }
    @Test
    public void testConstructor() {
        ResultDAOImpl resultDAOImpl = new ResultDAOImpl();
        Assertions.assertNotNull(resultDAOImpl);
    }
}
