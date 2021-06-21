package com.resultcopy.service.impl;
import com.resultcopy.ChildResponse;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.ChildDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author AC089545
 */
/**
 * returns child details of a patient.
 */
public class ChildDAOImpl implements ChildDAO {
    private ConnectionFactory connectionFactory;
    public ChildDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    public ChildDAOImpl() {

    }

    /**
     * @param patientId
     *          patientId is the unique identifier for the patient.
     */
    @Override
    public List<PatientDetailsResponse> getPatientById(Integer patientId) {
        PatientResponse patient = null;
        PatientDetailsResponse patientDetailsResponse = null;
        List<PatientDetailsResponse> childDetails = new ArrayList<>();
        ChildResponse child = new ChildResponse();
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT c.child_id ,c.first_name,c.last_name,c.mrn,c.fin FROM patient p ,Child c WHERE p.PATIENT_ID = c.Patient_Id  AND p.PATIENT_ID = "+patientId;
        System.out.println("SQL :"+sql);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientDetailsResponse= new PatientDetailsResponse();
                patientDetailsResponse.setId(resultSet.getInt("CHILD_ID"));
                patientDetailsResponse.setFirstName(resultSet.getString("FIRST_NAME"));
                patientDetailsResponse.setLastName(resultSet.getString("LAST_NAME"));
                patientDetailsResponse.setMrn(resultSet.getString("MRN"));
                patientDetailsResponse.setFin(resultSet.getString("FIN"));
                childDetails.add(patientDetailsResponse);
            }
            patient = new PatientResponse();
            patient.setPatientDetails(patientDetailsResponse);
        }catch (SQLException ex){
            new RuntimeException("fails");
        }
        child.setChildDetails(childDetails);
        return childDetails;
    }
}
