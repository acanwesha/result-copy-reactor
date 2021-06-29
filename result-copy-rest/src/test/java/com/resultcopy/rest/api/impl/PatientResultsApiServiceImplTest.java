package com.resultcopy.rest.api.impl;

import com.resultcopy.rest.api.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author AC089545
 * Test case for CopyResultsApiServiceImpl class.
 */
@RunWith(MockitoJUnitRunner.class)
class PatientResultsApiServiceImplTest {
  @Mock SecurityContext securityContext;

  /**
   * Test case for asserting the patientId response.
   * @throws NotFoundException  Throws exception when response won't be set.
   */
  @Test
  void  testPatientResultsPatientIdGet() throws NotFoundException {
    PatientResultsApiServiceImpl patientResultsApiService = new PatientResultsApiServiceImpl();
    String patientId = "1";
    Response response = patientResultsApiService.patientResultsPatientIdGet(patientId, securityContext);
    assertEquals(200, response.getStatus());
  }
}
