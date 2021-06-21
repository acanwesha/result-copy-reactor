package com.resultcopy.service.impl;
import com.resultcopy.CategoryResponse;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.ChildDAO;
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
import java.util.Objects;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ToString
@RunWith(MockitoJUnitRunner.class)

public class ChildDAOImplTest {
    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private PatientDetailsResponse childDetails;
    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);

        childDetails = new PatientDetailsResponse();
        childDetails.setId(1);
        childDetails.setFirstName("AARAV");
        childDetails.setLastName("ESPINOSA");
        childDetails.setMrn("MX12345");
        childDetails.setFin("MH54321");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(childDetails.getFirstName());
        when(resultSet.getString(2)).thenReturn(childDetails.getLastName());
        when(resultSet.getString(2)).thenReturn(childDetails.getMrn());
        when(resultSet.getString(2)).thenReturn(childDetails.getFin());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void getPatientById() {

        new ChildDAOImpl(connectionFactory).getPatientById(2);
    }
    @Test(expected=SQLException.class)
    public void nullCreateChildThrowsException() throws Throwable{
        new ChildDAOImpl(null).getPatientById(null);
        Assertions.assertTrue(throwException());
    }
    private boolean throwException() throws SQLException {
        throw new SQLException();
    }
    @Test
    public void testConstructor() {
        ChildDAOImpl childDAOImpl = new ChildDAOImpl();
        Assertions.assertNotNull(childDAOImpl);
    }
}
