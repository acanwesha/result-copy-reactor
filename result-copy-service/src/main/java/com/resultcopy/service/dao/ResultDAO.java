package com.resultcopy.service.dao;
import com.resultcopy.ChildResultResponse;
import com.resultcopy.ResultResponse;

import java.util.List;
/**
 * @author AC089545
 */
/**
 * Interface ResultDAO containing the method to get the result details of a patient.
 */
public interface ResultDAO {
    /**
     * @param categoryId
     *          categoryId is the unique identifier for a particular category.
     */
    public List<ResultResponse> getCategories(Integer categoryId);
    public List<ChildResultResponse> getChildValueById(Integer patientId);
}
