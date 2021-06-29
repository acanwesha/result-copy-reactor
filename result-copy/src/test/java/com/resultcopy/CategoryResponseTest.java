package com.resultcopy;

import com.resultcopy.CategoryResponse;
import com.resultcopy.ResultResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/** @author AC089545 Test case of CategoryResponse. */
public class CategoryResponseTest {
  CategoryResponse categoryResponse = new CategoryResponse();

  /** Test case for the setter and getter of CategoryResponseId. */
  @Test
  public void testCategoryResponseId() {
    categoryResponse.setId(2);
    Assertions.assertEquals(2, categoryResponse.getId());
  }

  /** Test case for the setter and getter of CategoryResponseId. */
  @Test
  public void testCategoryResponseCategoryName() {
    categoryResponse.setDisplayName("DELIVERY_INFORMATION");
    Assertions.assertEquals("DELIVERY_INFORMATION", categoryResponse.getDisplayName());
  }

  /** Test case for the setter and getter of CategoryResult. */
  @Test
  public void testCategoryResponseCategoryResult() {
    List<ResultResponse> resultList = new ArrayList<>();
    ResultResponse resultResponse = new ResultResponse();
    resultResponse.setId(1);
    resultResponse.setDisplayName("PREGNANCY_OUTCOME");
    resultResponse.setValue("VAGINAL_BIRTH");
    resultList.add(resultResponse);
    categoryResponse.setResult(resultList);
    Assertions.assertEquals(resultList, categoryResponse.getResult());
  }
}
