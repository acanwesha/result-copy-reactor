package com.resultcopy.service.impl;
import com.resultcopy.ChildResponse;
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
    @Mock
    private PatientDAOImpl mock;
    @Mock
    private PatientDetailsResponse patientDetailsResponse;
    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
    }
    @Test
    public void getPatientById() throws SQLException {

        patientDetails = new PatientDetailsResponse();
        patientDetails.setId(1);
        patientDetails.setFirstName("EMMA");
        patientDetails.setLastName("ESPINOSA");
        patientDetails.setMrn("MX13216584");
        patientDetails.setFin(" MX26548913");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(patientDetails.getId());
        when(resultSet.getString(2)).thenReturn(patientDetails.getFirstName());
        when(resultSet.getString(3)).thenReturn(patientDetails.getLastName());
        when(resultSet.getString(4)).thenReturn(patientDetails.getMrn());
        when(resultSet.getString(5)).thenReturn(patientDetails.getFin());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        patientDetailsResponse = new PatientDetailsResponse();
        patientDetailsResponse.setId(resultSet.getInt(1));
        patientDetailsResponse.setFirstName(resultSet.getString(2));
        patientDetailsResponse.setLastName(resultSet.getString(3));
        patientDetailsResponse.setMrn(resultSet.getString(4));
        patientDetailsResponse.setFin(resultSet.getString(5));
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientDetails(patientDetailsResponse);
        mock = org.mockito.Mockito.mock(PatientDAOImpl.class);
        when(mock.getPatientById(1)).thenReturn(patientResponse);

        PatientResponse p = new PatientDAOImpl(connectionFactory).getPatientById(1);

        Assertions.assertEquals(p.getPatientDetails().getId(),patientResponse.getPatientDetails().getId());

    }

    @Test
    public void testConstructor() {
        PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
        Assertions.assertNotNull(patientDAOImpl);
    }
}
