package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

public class CategoryRequestTest {

    @Mock
    List<ResultRequest> resultRequests;
    CategoryRequest categoryRequest = new CategoryRequest();

    @Test
    public void testDisplayName(){
        categoryRequest.setDisplayName("DELIVERY_INFORMATION");
        Assertions.assertEquals("DELIVERY_INFORMATION",categoryRequest.getDisplayName());
    }

    @Test
    public void testResultList(){
        categoryRequest.setResult(resultRequests);
        Assertions.assertEquals(resultRequests,categoryRequest.getResult());
    }
}
