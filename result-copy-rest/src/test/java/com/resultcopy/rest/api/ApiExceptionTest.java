package com.resultcopy.rest.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author AC089545
 * Test case for ApiException class.
 */
@RunWith(MockitoJUnitRunner.class)
class ApiExceptionTest {

  /**
   * Test case for NotFoundException method.
   */
  @Test
  public void testNotFoundException() {
    NotFoundException notFoundException = new NotFoundException(1, "done");
    assertNotNull(notFoundException);
  }
}
