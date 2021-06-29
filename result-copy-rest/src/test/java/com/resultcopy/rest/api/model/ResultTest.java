package com.resultcopy.rest.api.model;

import com.resultcopy.rest.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AC089545
 * Test case for Result.
 */
public class ResultTest {
  Result result = new Result();

  /** Test case for the setter and getter for Id. */
  @Test
  public void testResultId() {
    result.setId(1);
    Assertions.assertEquals(1, result.getId());
  }

  /** Test case for the setter and getter for DisplayName. */
  @Test
  public void testResultDisplayName() {
    result.setDisplayName("PREGNANCY_OUTCOME");
    Assertions.assertEquals("PREGNANCY_OUTCOME", result.getDisplayName());
  }

  /** Test case for the setter and getter for ResultValue. */
  @Test
  public void testResultValue() {
    result.setValue("VAGINAL_BIRTH");
    Assertions.assertEquals("VAGINAL_BIRTH", result.getValue());
  }

  /** Test for constructor Id. */
  @Test
  public void testConstructorId() {
    Assertions.assertNotNull(result.id(12));
  }

  /** Test for constructor DisplayName. */
  @Test
  public void testConstructorDisplayName() {
    Assertions.assertNotNull(result.displayName("DELIVERY_INFORMATION"));
  }

  /** Test for constructor Value. */
  @Test
  public void testConstructorValue() {
    Assertions.assertNotNull(result.value("VAGINAL_BIRTH"));
  }

  /** Test for toString method */
  @Test
  public void testToStringReturnString(){
    Assertions.assertEquals(result.toString(), "class Result {\n" +
            "    id: null\n" +
            "    displayName: null\n" +
            "    value: null\n" +
            "}");
  }

  /**
   * Test for equals method
   */
  @Test public void testEqualsTrue() {
    Object object = null;;
    Assertions.assertEquals(result.equals(object), false);
  }
}
