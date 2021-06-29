package com.resultcopy.service.impl;
import com.resultcopy.ChildResponse;
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
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
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
    @Mock
    private ChildDAOImpl mock;
    @Mock
    private PatientDetailsResponse c1;

    @BeforeEach
    void setUp() throws Exception{
        Assertions.assertNotNull(connectionFactory);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(connectionFactory.getConnection()).thenReturn(connection);
    }
    @Test
    public void getPatientById() throws SQLException {

        childDetails = new PatientDetailsResponse();
        childDetails.setId(10);
        childDetails.setFirstName("AARAV");
        childDetails.setLastName("ESPINOSA");
        childDetails.setMrn("MX12345");
        childDetails.setFin("MH54321");

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(childDetails.getId());
        when(resultSet.getString(2)).thenReturn(childDetails.getFirstName());
        when(resultSet.getString(3)).thenReturn(childDetails.getLastName());
        when(resultSet.getString(4)).thenReturn(childDetails.getMrn());
        when(resultSet.getString(5)).thenReturn(childDetails.getFin());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        c1 = new PatientDetailsResponse();
        c1.setId(resultSet.getInt(1));
        c1.setFirstName(resultSet.getString(2));
        c1.setLastName(resultSet.getString(3));
        c1.setMrn(resultSet.getString(4));
        c1.setFin(resultSet.getString(5));
        List<PatientDetailsResponse> childList = new ArrayList<>();
        childList.add(c1);
        ChildResponse child = new ChildResponse();
        child.setChildDetails(childList);
        mock = org.mockito.Mockito.mock(ChildDAOImpl.class);
        when(mock.getPatientById(1)).thenReturn(childList);
        List<PatientDetailsResponse> ch = new ChildDAOImpl(connectionFactory).getPatientById(1);
        Assertions.assertEquals(ch.listIterator().next().getId(),childList.listIterator().next().getId());

    }

    @Test
    public void testConstructor() {
        ChildDAOImpl childDAOImpl = new ChildDAOImpl();
        Assertions.assertNotNull(childDAOImpl);
    }
    @Test(expected = SQLException.class)
    public void nullCreateChildThrowsException() throws SQLException {
        mock = org.mockito.Mockito.mock(ChildDAOImpl.class);
        Assertions.assertTrue((BooleanSupplier) when(connectionFactory.getConnection().prepareStatement(null)).thenThrow(new SQLException()));
    }

}


