package com.resultcopy.service.serviceimpl;
import com.resultcopy.*;
import com.resultcopy.service.dao.*;
import com.resultcopy.service.impl.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author AC089545
 */
/**
 * returns the patient result.
 */
public class PatientServiceImpl {
    PatientDAO patientDAO = new PatientDAOImpl();
    ChildDAO childDAO = new ChildDAOImpl() ;
    ResultDAO resultDAO = new ResultDAOImpl();
    public PatientResultResponse getPatientDetails(String patientId){
        PatientResultResponse patient = new PatientResultResponse();
        PatientResponse patientResponse =patientDAO.getPatientById(Integer.parseInt(patientId));
        List<PatientDetailsResponse> patientDetailsList = childDAO.getPatientById(Integer.parseInt(patientId));
        List<ChildResponse> childResponseList = new ArrayList<>();
        ChildResponse childResponse = new ChildResponse();
        childResponse.setChildDetails(patientDetailsList);
        childResponseList.add(childResponse);
        CategoryDAO categoryDAO=new CategoryDAOImpl();
        List<CategoryResponse> categoryList = categoryDAO.getCategories();
        BabyResultDAO babyResultDAO = new BabyResultDAOImpl();
        for(PatientDetailsResponse patientDetail:patientDetailsList) {
            BabyResultResponse babyResultResponse = babyResultDAO.getBabyPatientByChildId(patientDetail.getId());
            if(null!=babyResultResponse){
                patientDetail.setResultCopiedDateTime(babyResultResponse.getDateTime());
            }else {
                patient.setCategory(categoryList);
                for(CategoryResponse category:categoryList) {
                    List<ChildResultResponse> childResultsList =resultDAO.getChildValueById(Integer.parseInt(patientId));
                    List<ResultResponse> resultList = resultDAO.getCategories(category.getId());
                    ResultResponse resultDto=null;
                    for (ChildResultResponse childResultResponse : childResultsList) {
                        resultDto = new ResultResponse();
                        for(ResultResponse result :resultList) {
                            if (result.getId() == childResultResponse.getResultId()) {
                                result.setValue(childResultResponse.getValue());
                            }
                        }
                    }
                    resultList.add(resultDto);
                    category.setResult(resultList);
                    }
                }
            }
        patient.setPatient(patientResponse);
        patient.setChild(childResponseList);
        return patient;
    }
}
