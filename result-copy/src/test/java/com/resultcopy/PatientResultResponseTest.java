package com.resultcopy;

import com.resultcopy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author AC089545 Test case for PatientDetailsResponse. */
public class PatientResultResponseTest {
  PatientResultResponse patientResultResponse = new PatientResultResponse();

  /** Tests for the patient response list in PatientResult. */
  @Test
  public void testPatientResponsePatient() {
    PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
    patientDetailsResponse.setId(1);
    patientDetailsResponse.setFirstName("EMMA");
    patientDetailsResponse.setLastName("ESPINOSA");
    patientDetailsResponse.setMrn("MX123");
    patientDetailsResponse.setFin("MH123");
    PatientResponse patient = new PatientResponse();
    patient.setPatientDetails(patientDetailsResponse);
    patientResultResponse.setPatient(patient);
    Assertions.assertEquals(patient, patientResultResponse.getPatient());
  }

  /** Tests for the child response list in PatientResult. */
  @Test
  public void testPatientResponseChild() {
    PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
    List<PatientDetailsResponse> childList = new ArrayList<>();
    List<ChildResponse> childResponseList = new ArrayList<>();
    patientDetailsResponse.setId(1);
    patientDetailsResponse.setFirstName("AARAV");
    patientDetailsResponse.setLastName("ESPINOSA");
    patientDetailsResponse.setMrn("MX123");
    patientDetailsResponse.setFin("MH123");
    ChildResponse child = new ChildResponse();
    childList.add(patientDetailsResponse);
    child.setChildDetails(childList);
    childResponseList.add(child);
    patientResultResponse.setChild(childResponseList);
    Assertions.assertEquals(childResponseList, patientResultResponse.getChild());
  }

  /** Tests for the category response list in PatientResult. */
  @Test
  public void testCategoryResponse() {
    CategoryResponse categoryResponse = new CategoryResponse();
    categoryResponse.setId(2);
    categoryResponse.setDisplayName("DELIVERY_INFORMATION");
    List<ResultResponse> resultList = new ArrayList<>();
    ResultResponse resultResponse = new ResultResponse();
    resultResponse.setId(1);
    resultResponse.setDisplayName("PREGNANCY_OUTCOME");
    resultResponse.setValue("VAGINAL_BIRTH");
    resultList.add(resultResponse);
    categoryResponse.setResult(resultList);
    List<CategoryResponse> categoryList = new ArrayList<>();
    categoryList.add(categoryResponse);
    patientResultResponse.setCategory(categoryList);
    Assertions.assertEquals(categoryList, patientResultResponse.getCategory());
  }
}
