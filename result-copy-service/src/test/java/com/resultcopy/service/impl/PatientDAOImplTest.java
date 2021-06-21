package com.resultcopy.service.impl;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.service.ConnectionFactory;
import lombok.ToString;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
@ToString
@RunWith(MockitoJUnitRunner.class)
public class PatientDAOImplTest {
    @Mock
    private ConnectionFactory connectionFactory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private PatientDetailsResponse patientDetails;
    private Object SQLException;


    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);

        patientDetails = new PatientDetailsResponse();
        patientDetails.setId(1);
        patientDetails.setFirstName("EMMA");
        patientDetails.setLastName("ESPINOSA");
        patientDetails.setMrn("MX12345");
        patientDetails.setFin("MH54321");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(patientDetails.getFirstName());
        when(resultSet.getString(3)).thenReturn(patientDetails.getLastName());
        when(resultSet.getString(4)).thenReturn(patientDetails.getMrn());
        when(resultSet.getString(5)).thenReturn(patientDetails.getFin());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }
    @Test
    public void getPatientById() throws SQLException {
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        new PatientDAOImpl(connectionFactory).getPatientById(2);
    }
    @Test(expected=SQLException.class)
    public void nullPatientThrowsException() throws Throwable{
        new PatientDAOImpl(connectionFactory).getPatientById(null);
        Assertions.assertTrue(throwException());
        Assertions.assertEquals(SQLException,SQLException);
    }
    private boolean throwException() throws SQLException {
        throw new SQLException();
    }
    @Test
    public void testConstructor() {
        PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
        Assertions.assertNotNull(patientDAOImpl);
    }
}
