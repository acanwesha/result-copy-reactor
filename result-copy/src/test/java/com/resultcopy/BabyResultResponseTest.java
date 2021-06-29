package com.resultcopy;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AC089545
 * Test case of BabyResultResponse.
 */
public class BabyResultResponseTest {
    BabyResultResponse babyResultResponse = new BabyResultResponse();

    /**
     * Test case for the setter and getter for Id.
     */
    @Test
    public void testBabyResultResponseId() {
        babyResultResponse.setChildId(1);
        Assertions.assertEquals(1, babyResultResponse.getChildId());
    }

    /**
     * Test case for the setter and getter for CategoryName.
     */
    @Test
    public void testBabyResultResponseCategoryName() {
        babyResultResponse.setCategoryName("DELIVERY_INFORMATION");
        Assertions.assertEquals("DELIVERY_INFORMATION", babyResultResponse.getCategoryName());
    }

    /**
     * Test case for the setter and getter for ResultName.
     */
    @Test
    public void testBabyResultResponseResultName() {
        babyResultResponse.setResultName("PREGNANCY_OUTCOME");
        Assertions.assertEquals("PREGNANCY_OUTCOME", babyResultResponse.getResultName());
    }

    /**
     * Test case for the setter and getter for ResultValue.
     */
    @Test
    public void testBabyResultResponseResultValue() {
        babyResultResponse.setValue("VAGINAL_BIRTH");
        Assertions.assertEquals("VAGINAL_BIRTH", babyResultResponse.getValue());
    }

    /**
     * Test case for the setter and getter for ResultDate.
     */
    @Test
    public void testBabyResultResponseResultDate() {
        Date date = new Date();
        babyResultResponse.setDateTime(date);
        Assertions.assertEquals(date, babyResultResponse.getDateTime());
    }
}
