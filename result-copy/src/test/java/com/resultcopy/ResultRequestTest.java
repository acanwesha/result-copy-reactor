package com.resultcopy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

public class ResultRequestTest {

    ResultRequest resultRequest = new ResultRequest();
    @Test
    public void testDisplayName(){
        resultRequest.setDisplayName("PREGNANCY_OUTCOME");
        Assertions.assertEquals("PREGNANCY_OUTCOME",resultRequest.getDisplayName());
    }
    @Test
    public void testValue(){
        resultRequest.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH",resultRequest.getValue());
    }
}
