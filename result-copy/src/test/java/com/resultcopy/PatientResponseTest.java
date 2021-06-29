package com.resultcopy;

import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @author AC089545 Test case for PatientResponse. */
public class PatientResponseTest {

  /** Test case for the setters and getters. */
  @Test
  public void testPatientResponse() {
    PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
    patientDetailsResponse.setId(1);
    patientDetailsResponse.setFirstName("EMMA");
    patientDetailsResponse.setLastName("ESPINOSA");
    patientDetailsResponse.setMrn("MX123");
    patientDetailsResponse.setFin("MH123");
    PatientResponse patient = new PatientResponse();
    patient.setPatientDetails(patientDetailsResponse);
    Assertions.assertEquals(patientDetailsResponse, patient.getPatientDetails());
  }
}
