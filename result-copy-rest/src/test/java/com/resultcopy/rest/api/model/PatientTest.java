package com.resultcopy.rest.api.model;

import com.resultcopy.rest.model.Patient;
import com.resultcopy.rest.model.PatientDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AC089545
 * Test case for Patient.
 */
public class PatientTest {
  Patient patient = new Patient();
  PatientDetails patientDetails;

  /** Test case for the setter and getters */
  @Test
  public void testPatientResponse() {
    patientDetails = new PatientDetails();
    patientDetails.setId(1);
    patientDetails.setFirstName("EMMA");
    patientDetails.setLastName("ESPINOSA");
    patientDetails.setMrn("MX123");
    patientDetails.setFin("MH123");
    patient.setPatientDetails(patientDetails);
    Assertions.assertEquals(patientDetails, patient.getPatientDetails());
  }

  /** Test for constructor PatientDetails. */
  @Test
  public void testConstructor() {
    Assertions.assertNotNull(patient.patientDetails(patientDetails));
  }

  /** Test for toString method */
  @Test
  public void testToStringReturnString(){
    Assertions.assertEquals(patient.toString(), "class Patient {\n" +
            "    patientDetails: null\n" +
            "}");
  }

  /**
   * Test for equals method
   */
  @Test public void testEqualsTrue() {
    Object object = null;;
    Assertions.assertEquals(patient.equals(object), false);
  }
}
