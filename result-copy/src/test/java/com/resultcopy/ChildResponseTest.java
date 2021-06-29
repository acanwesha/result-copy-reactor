package com.resultcopy;

import com.resultcopy.ChildResponse;
import com.resultcopy.PatientDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author AC089545 Test case for ChildDetailsResponse. */
public class ChildResponseTest {

  /** Test case for the setters and getters. */
  @Test
  public void testChildResponse() {
    PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
    List<PatientDetailsResponse> childList = new ArrayList<>();
    patientDetailsResponse.setId(1);
    patientDetailsResponse.setFirstName("AARAV");
    patientDetailsResponse.setLastName("ESPINOSA");
    patientDetailsResponse.setMrn("MX123");
    patientDetailsResponse.setFin("MH123");
    Date date = new Date();
    patientDetailsResponse.setResultCopiedDateTime(date);
    ChildResponse child = new ChildResponse();
    childList.add(patientDetailsResponse);
    child.setChildDetails(childList);
    Assertions.assertEquals(childList, child.getChildDetails());
  }

  @Test
  public void testBabyResultResponseResultDate() {
    ChildResponse child = new ChildResponse();
    Date date = new Date();
    child.setResultCopiedDateTime(date);
    Assertions.assertEquals(date, child.getResultCopiedDateTime());
  }
}
