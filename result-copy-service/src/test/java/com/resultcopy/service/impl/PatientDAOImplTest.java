package com.resultcopy.service.impl;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import com.resultcopy.service.ConnectionFactory;
import lombok.ToString;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
    private PatientResponse patient;
    @Mock
    private PatientDAOImpl patientDAO;



    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
        patient=new PatientResponse();
        patientDetails=new PatientDetailsResponse();
/*

        when(patientDetails.getId()).thenReturn(1);
        when(patientDetails.getFirstName()).thenReturn("EMM");
        when(patientDetails.getLastName()).thenReturn("ESPINOSA");
        when(patientDetails.getMrn()).thenReturn("MX13216584");
        when(patientDetails.getFin()).thenReturn("MX26548913");
        patient.setPatientDetails(patientDetails);
        when(patient.getPatientDetails()).thenReturn(patientDetails);
        PatientDAOImpl patientDAO=new PatientDAOImpl();
        when(patientDAO.getPatientById(1)).thenReturn(patient);
  */
        patientDetails.setId(1);
        patientDetails.setFirstName("EMMA");
        patientDetails.setLastName("ESPINOSA");
        patientDetails.setMrn("MX12345");
        patientDetails.setFin("MH54321");
        patient.setPatientDetails(patientDetails);

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(1);
        when(resultSet.getString(2)).thenReturn(patientDetails.getFirstName());
        when(resultSet.getString(3)).thenReturn(patientDetails.getLastName());
        when(resultSet.getString(4)).thenReturn(patientDetails.getMrn());
        when(resultSet.getString(5)).thenReturn(patientDetails.getFin());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        patientDetails.setId(resultSet.getInt(1));
        patientDetails.setFirstName(resultSet.getString(2));
        patientDetails.setLastName(resultSet.getString(3));
        patientDetails.setMrn(resultSet.getString(4));
        patientDetails.setFin(resultSet.getString(5));
        patient.setPatientDetails(patientDetails);
        PatientDAOImpl patientDAO=new PatientDAOImpl();
        when(patientDAO.getPatientById(1)).thenReturn(patient);
    }
    @Test
    public void getPatientById() throws SQLException {
        PatientResponse actual=new PatientDAOImpl(connectionFactory).getPatientById(1);
        Assertions.assertNotEquals(patient,actual);
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
