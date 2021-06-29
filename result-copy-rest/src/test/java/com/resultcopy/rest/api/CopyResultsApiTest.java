package com.resultcopy.rest.api;

import com.resultcopy.rest.model.BabyResult;
import com.resultcopy.rest.model.CategoryPost;
import com.resultcopy.rest.model.CategoryPostResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author AC089545
 * Test case for {@link CopyResultsApi}
 */

@RunWith(MockitoJUnitRunner.class)
class CopyResultsApiTest {
    private @Mock SecurityContext securityContext;
    private @Mock BabyResult babyResult;

    /**
     * Test response for the copy result API.
     * @throws NotFoundException NotFoundException.
     */

    @Test
    void testCopyResultsPost() throws NotFoundException {
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
        Response response = new CopyResultsApi().copyResultsPost(babyResult, securityContext);
        System.out.println(response);
        assertEquals(200, response.getStatus());
        assertTrue((boolean)response.getEntity());
    }
}
