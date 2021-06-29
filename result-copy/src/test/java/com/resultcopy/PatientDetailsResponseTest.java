package com.resultcopy;

import com.resultcopy.PatientDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/** @author AC089545 Test case for PatientDetailsResponse. */
public class PatientDetailsResponseTest {

  PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();

  /** Test case for the setter and getter for Id. */
  @Test
  public void testPatientDetailsResponseId() {
    patientDetailsResponse.setId(1);
    Assertions.assertEquals(1, patientDetailsResponse.getId());
  }

  /** Test case for the setter and getter for FirstName. */
  @Test
  public void testPatientDetailsResponseFirstName() {
    patientDetailsResponse.setFirstName("EMMA");
    Assertions.assertEquals("EMMA", patientDetailsResponse.getFirstName());
  }

  /** Test case for the setter and getter for LastName. */
  @Test
  public void testPatientDetailsResponseLastName() {
    patientDetailsResponse.setLastName("ESPINOSA");
    Assertions.assertEquals("ESPINOSA", patientDetailsResponse.getLastName());
  }

  /** Test case for the setter and getter for Mrn. */
  @Test
  public void testPatientDetailsResponseMrn() {
    patientDetailsResponse.setMrn("MX123");
    Assertions.assertEquals("MX123", patientDetailsResponse.getMrn());
  }

  /** Test case for the setter and getter for Fin. */
  @Test
  public void testPatientDetailsResponseFin() {
    patientDetailsResponse.setFin("MH123");
    Assertions.assertEquals("MH123", patientDetailsResponse.getFin());
  }

  /** Test case for the setter and getter for Date. */
  @Test
  public void testPatientDetailsResponseDate() {
    Date date = new Date();
    patientDetailsResponse.setResultCopiedDateTime(date);
    Assertions.assertEquals(date, patientDetailsResponse.getResultCopiedDateTime());
  }
}
