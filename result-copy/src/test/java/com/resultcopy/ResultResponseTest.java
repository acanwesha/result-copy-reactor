package com.resultcopy;

import com.resultcopy.ResultResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @author AC089545 Test case for PatientDetailsResponse. */
public class ResultResponseTest {

  /** Test case for the setters and getters. */
  @Test
  public void testResultResponse() {
    ResultResponse resultResponse = new ResultResponse();
    resultResponse.setId(1);
    resultResponse.setDisplayName("PREGNANCY_OUTCOME");
    resultResponse.setValue("VAGINAL_BIRTH");
    Assertions.assertEquals(1, resultResponse.getId());
    Assertions.assertEquals("PREGNANCY_OUTCOME", resultResponse.getDisplayName());
    Assertions.assertEquals("VAGINAL_BIRTH", resultResponse.getValue());
  }
}
