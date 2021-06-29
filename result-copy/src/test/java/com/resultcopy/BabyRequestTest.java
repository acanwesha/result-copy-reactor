package com.resultcopy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class BabyRequestTest {

    @Mock
    List<ResultRequest> resultRequests;

    @Mock
    CategoryRequest categoryRequest;
    BabyRequest babyRequest = new BabyRequest();

    @Test
    public void testChildId() {
        babyRequest.setChildId(11);
        Assertions.assertEquals(11, babyRequest.getChildId());
    }

    @Test
    public void testCategoryRequest() {
        categoryRequest = new CategoryRequest();
        categoryRequest.setDisplayName("DELIVERY_INFORMATION");
        categoryRequest.setResult(resultRequests);
        List<CategoryRequest> categoryRequestList = new ArrayList<>();
        categoryRequestList.add(categoryRequest);
        babyRequest.setCategory(categoryRequestList);
        Assertions.assertEquals(categoryRequestList,babyRequest.getCategory());
    }
}
