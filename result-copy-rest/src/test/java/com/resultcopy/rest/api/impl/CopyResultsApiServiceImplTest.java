package com.resultcopy.rest.api.impl;

import com.resultcopy.rest.api.NotFoundException;
import com.resultcopy.rest.model.BabyResult;
import com.resultcopy.rest.model.CategoryPost;
import com.resultcopy.rest.model.CategoryPostResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author AC089545
 * Test case for CopyResultsApiServiceImpl class.
 */
@RunWith(MockitoJUnitRunner.class)
class CopyResultsApiServiceImplTest {
  @Mock SecurityContext securityContext;
  @Mock BabyResult babyResult;

  /**
   * Test case for copy result post method asserting the response returned as true.
   * @throws NotFoundException  Throws exception when response won't be set.
   */
  @Test
  public void testCopyResultsPost() throws NotFoundException {
    babyResult = new BabyResult();
    babyResult.setChildId(10);
    CategoryPost categoryPost= new CategoryPost();
    List<CategoryPost> categoryPostList=new ArrayList<>();
    categoryPost.setDisplayName("DELIVERY_INFORMATION");
    CategoryPostResult categoryPostResult=new CategoryPostResult();
    List<CategoryPostResult> categoryPostResultList=new ArrayList<>();
    categoryPostResult.setDisplayName("PREGNANCY_OUTCOME");
    categoryPostResult.setValue("VAGINAL_BIRTH");
    categoryPostResultList.add(categoryPostResult);
    categoryPost.setResult(categoryPostResultList);
    categoryPostList.add(categoryPost);
    babyResult.setCategory(categoryPostList);
    CopyResultsApiServiceImpl copyResultsApiService = new CopyResultsApiServiceImpl();
    Response response = copyResultsApiService.copyResultsPost(babyResult, securityContext);
    assertEquals(200, response.getStatus());
    assertTrue((boolean)response.getEntity());
  }
}
