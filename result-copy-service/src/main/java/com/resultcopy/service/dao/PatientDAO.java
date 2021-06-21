package com.resultcopy.service.dao;
import com.resultcopy.PatientResponse;
/**
 * @author AC089545
 */
/**
 * Interface PatientDAO containing the method to get the patient details.
 */
public interface PatientDAO {
    /**
     * @param patientId
     *          patientId is the unique identifier for the patient.
     */
    PatientResponse getPatientById(Integer patientId);
}
