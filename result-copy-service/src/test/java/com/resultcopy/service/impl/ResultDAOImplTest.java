package com.resultcopy.service.impl;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.resultcopy.*;
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
    private ResultDAOImpl mock;
    @Mock
    private ResultResponse resultResponses;
    @Mock
    private ChildResultResponse childResponse;

    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
    }

    @Test
    public void testCategoryDAOImpl() throws SQLException {
        ResultResponse resultResponse = new ResultResponse();
        List<ResultResponse> resultResponseList = new ArrayList<>();
        resultResponse.setId(20);
        resultResponse.setDisplayName("PREGNANCY_OUTCOME");
        resultResponse.setValue("VAGINAL_BIRTH");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(resultResponse.getId());
        when(resultSet.getString(2)).thenReturn(resultResponse.getDisplayName());
        when(resultSet.getString(3)).thenReturn(resultResponse.getValue());

        resultResponses = new ResultResponse();
        resultResponses.setId(resultSet.getInt(1));
        resultResponses.setDisplayName(resultSet.getString(2));
        resultResponseList.add(resultResponses);

        mock = org.mockito.Mockito.mock(ResultDAOImpl.class);
        when(mock.getCategories(12)).thenReturn(resultResponseList);

        List<ResultResponse> resultResponseList1 = new ResultDAOImpl(connectionFactory).getCategories(12);

        Assertions.assertEquals(resultResponseList.listIterator().next().getDisplayName(),resultResponseList1.listIterator().next().getDisplayName());
    }
    @Test
    public void testConstructor() {
        ResultDAOImpl resultDAOImpl = new ResultDAOImpl();
        Assertions.assertNotNull(resultDAOImpl);
    }

    @Test
    public void getChildValueById() throws SQLException {
        List<ChildResultResponse> resultList=new ArrayList<>();
        ChildResultResponse patientResponse = new ChildResultResponse();

        patientResponse.setChildId(11);
        patientResponse.setResultId(20);
        patientResponse.setValue("VAGINAL_BIRTH");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(patientResponse.getChildId());
        when(resultSet.getInt(2)).thenReturn(patientResponse.getResultId());
        when(resultSet.getString(3)).thenReturn(patientResponse.getValue());

        ChildResultResponse patientResponses = new ChildResultResponse();
        patientResponses.setChildId(resultSet.getInt(1));
        patientResponses.setResultId(resultSet.getInt(2));
        patientResponses.setValue(resultSet.getString(3));
        resultList.add(patientResponses);

        mock = org.mockito.Mockito.mock(ResultDAOImpl.class);
        when(mock.getChildValueById(3)).thenReturn(resultList);
        List<ChildResultResponse> resultResponseList1 = new ResultDAOImpl(connectionFactory).getChildValueById(3);
        Assertions.assertEquals(resultResponseList1.listIterator().next().getResultId(),resultList.listIterator().next().getResultId());

    }
}