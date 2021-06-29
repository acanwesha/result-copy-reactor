package com.resultcopy.rest.api.model;

import com.resultcopy.rest.model.Category;
import com.resultcopy.rest.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AC089545
 * Test case for Category.
 */
public class CategoryTest {
  Category category = new Category();
  List<Result> resultList = null;

  /**
   * Test case for the setter and getter for CategoryId.
   */
  @Test
  public void testCategoryResponseId() {
    category.setId(2);
    Assertions.assertEquals(2, category.getId());
  }

  /**
   * Test case for the setter and getter for displayName.
   */
  @Test
  public void testCategoryResponseDisplayName() {
    category.setDisplayName("DELIVERY_INFORMATION");
    Assertions.assertEquals("DELIVERY_INFORMATION", category.getDisplayName());
  }

  /**
   * Test case for the setter and getter for ResultList.
   */
  @Test
  public void testCategoryResponseResultList() {
    List<Result> resultList = new ArrayList<>();
    Result resultResponse = new Result();
    resultResponse.setId(1);
    resultResponse.setDisplayName("PREGNANCY_OUTCOME");
    resultResponse.setValue("VAGINAL_BIRTH");
    resultList.add(resultResponse);
    category.setResult(resultList);
    Assertions.assertEquals(resultList, category.getResult());
  }

  /**
   * Test case for the constructor Id.
   */
  @Test
  public void testConstructorId() {
    Assertions.assertNotNull(category.id(12));
  }

  /**
   * Test case for the constructor DisplayName.
   */
  @Test
  public void testConstructorDisplayName() {
    Assertions.assertNotNull(category.displayName("DELIVERY_INFORMATION"));
  }

  /**
   * Test case for the constructor ResultList.
   */
  @Test
  public void testConstructorResultList() {
    Assertions.assertNotNull(category.result(resultList));
  }

  /**
   * Test for toString method
   */
  @Test
  public void testToStringReturnString(){
    Assertions.assertEquals(category.toString(), "class Category {\n" +
            "    id: null\n" +
            "    displayName: null\n" +
            "    result: null\n" +
            "}");
  }

  /**
   * Test for equals method
   */
  @Test public void testEqualsTrue() {
    Object object = null;;
    Assertions.assertEquals(category.equals(object), false);
  }
}
