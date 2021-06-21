package com.resultcopy.service.impl;
import com.resultcopy.BabyResultResponse;
import com.resultcopy.ChildResultResponse;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.service.ConnectionFactory;
import lombok.ToString;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ToString
@RunWith(MockitoJUnitRunner.class)
public class BabyResultDAOImplTest {
    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private BabyResultResponse babyResultResponse;
    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);

        babyResultResponse = new BabyResultResponse();
        babyResultResponse.setDateTime(any());

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getDate(1)).thenReturn((Date) babyResultResponse.getDateTime());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }
    @Test
    public void getBabyPatientByChildId() {
        new BabyResultDAOImpl(connectionFactory).getBabyPatientByChildId(3);
    }
    @Test(expected=SQLException.class)
    public void nullCreatePatientThrowsException() throws Throwable{
        new BabyResultDAOImpl(null).getBabyPatientByChildId(3);
        Assertions.assertTrue(throwException());
    }
    private boolean throwException() throws SQLException {
        throw new SQLException();
    }
    @BeforeEach
    void setUpChild() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
        when(preparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    public void testConstructor() {
        BabyResultDAOImpl babyResultDAOImpl = new BabyResultDAOImpl();
        Assertions.assertNotNull(babyResultDAOImpl);
    }
}
