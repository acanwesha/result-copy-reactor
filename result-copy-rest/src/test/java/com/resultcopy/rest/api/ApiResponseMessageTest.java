package com.resultcopy.rest.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author AC089545
 * Test cases for ApiResponseMessageTest class.
 */
class ApiResponseMessageTest {
  ApiResponseMessage apiResponseMessage = new ApiResponseMessage();

  /**
   * Test case for getCode method.
   */
  @Test
  void testGetCode() {
    apiResponseMessage.setCode(1);
    assertEquals(1, apiResponseMessage.getCode());
  }

  /**
   * Test case for setCode method.
   */
  @Test
  void testSetCode() {
    apiResponseMessage.setCode(1);
    assertNotNull(apiResponseMessage.getCode());
  }

  /**
   * Test case for getType method.
   */
  @Test
  void testGetType() {
    apiResponseMessage.setType("error");
    assertEquals("error", apiResponseMessage.getType());
  }

  /**
   * Test case for setType method.
   */
  @Test
  void testSetType() {
    apiResponseMessage.setType("error");
    assertNotNull(apiResponseMessage.getType());
  }

  /**
   * Test case for getMessage method.
   */
  @Test
  void testGetMessage() {
    apiResponseMessage.setMessage("Unavailable");
    assertEquals("Unavailable", apiResponseMessage.getMessage());
  }

  /**
   * Test case for setMessage method.
   */
  @Test
  void testSetMessage() {
    apiResponseMessage.setMessage("Unavailable");
    assertNotNull(apiResponseMessage.getMessage());
  }

  /**
   *  Test case for switch statement case ERROR.
   */
  @Test
  void testSwitchStatementCaseError() {
    apiResponseMessage.setType("ERROR");
    assertEquals("ERROR",(String) new ApiResponseMessage(1,"ERROR").message);
  }

  /**
   *  Test case for switch statement case WARNING.
   */
  @Test
  void testSwitchStatementCaseWarning() {
    apiResponseMessage.setType("WARNING");
    assertEquals("WARNING",(String) new ApiResponseMessage(2,"WARNING").message);
  }

  /**
   *  Test case for switch statement case INFO.
   */
  @Test
  void testSwitchStatementCaseInfo() {
    apiResponseMessage.setType("INFO");
    assertEquals("INFO",(String) new ApiResponseMessage(3,"INFO").message);
  }

  /**
   *  Test case for switch statement case OK.
   */
  @Test
  void testSwitchStatementCaseOk() {
    apiResponseMessage.setType("INFO");
    assertEquals("OK",(String) new ApiResponseMessage(4,"OK").message);
  }

  /**
   *  Test case for switch statement case TOO_BUSY.
   */
  @Test
  void testSwitchStatementCaseTooBusy() {
    apiResponseMessage.setType("TOO_BUSY");
    assertEquals("TOO_BUSY",(String) new ApiResponseMessage(5,"TOO_BUSY").message);
  }

  /**
   *  Test case for switch statement case Default.
   */
  @Test
  void testSwitchStatementCaseDefault() {
    apiResponseMessage.setType("unknown");
    assertEquals("unknown",(String) new ApiResponseMessage(6,"unknown").message);
  }
}
