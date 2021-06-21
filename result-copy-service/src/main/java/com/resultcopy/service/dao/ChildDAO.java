package com.resultcopy.service.dao;
import com.resultcopy.PatientDetailsResponse;
import java.util.List;
/**
 * @author AC089545
 */
/**
 * Interface ChildDAO containing the method to get the child details.
 */
public interface ChildDAO {
    /**
     * @param patientId
     *          patientId is the unique identifier for the patient.
     */
    List<PatientDetailsResponse> getPatientById(Integer patientId);
}
