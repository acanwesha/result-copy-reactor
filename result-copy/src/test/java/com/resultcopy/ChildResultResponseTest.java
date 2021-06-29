package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class ChildResultResponseTest {
    ChildResultResponse childResultResponse = new ChildResultResponse();

    @Test
    public void testResultId(){
        childResultResponse.setResultId(20);
        Assertions.assertEquals(20,childResultResponse.getResultId());
    }
    @Test
    public void testChildId(){
        childResultResponse.setChildId(12);
        Assertions.assertEquals(12,childResultResponse.getChildId());
    }
    @Test
    public void testValue(){
        childResultResponse.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH",childResultResponse.getValue());
    }
}
