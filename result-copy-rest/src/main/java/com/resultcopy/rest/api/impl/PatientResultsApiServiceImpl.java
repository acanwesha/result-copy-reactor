package com.resultcopy.rest.api.impl;
import com.resultcopy.*;
import com.resultcopy.rest.api.PatientResultsApiService;
import com.resultcopy.rest.api.NotFoundException;
import com.resultcopy.rest.model.*;
import com.resultcopy.service.dao.BabyResultDAO;
import com.resultcopy.service.dao.ResultDAO;
import com.resultcopy.service.impl.BabyResultDAOImpl;
import com.resultcopy.service.impl.ChildDAOImpl;
import com.resultcopy.service.impl.ResultDAOImpl;
import com.resultcopy.service.serviceimpl.PatientServiceImpl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class PatientResultsApiServiceImpl extends PatientResultsApiService {
    @Override
    public Response patientResultsPatientIdGet(String patientId, SecurityContext securityContext) throws NotFoundException {
        PatientServiceImpl patientService = new PatientServiceImpl();
        PatientResultResponse patientDto =patientService.getPatientDetails(patientId);
        PatientResult patientResult=new PatientResult();
        Patient patient=new Patient();
        List<Patient> patients=new ArrayList<>();
        PatientDetails patientDetails=new PatientDetails();
        patientDetails.setId(patientDto.getPatient().getPatientDetails().getId());
        patientDetails.firstName(patientDto.getPatient().getPatientDetails().getFirstName());
        patientDetails.lastName(patientDto.getPatient().getPatientDetails().getLastName());
        patientDetails.setMrn(patientDto.getPatient().getPatientDetails().getMrn());
        patientDetails.setFin(patientDto.getPatient().getPatientDetails().getFin());
        patient.setPatientDetails(patientDetails);
        patients.add(patient);
        System.out.println(patient);
        patientResult.setPatient(patients);
        ChildDAOImpl childDAO=new ChildDAOImpl();
        List<PatientDetailsResponse> patientDetailsList = childDAO.getPatientById(Integer.parseInt(patientId));
        List<PatientDetails> patientDetailsList1=new ArrayList<>();
        for(PatientDetailsResponse pl:patientDetailsList)
        {
            PatientDetails patientDetails1=new PatientDetails();
            patientDetails1.setId(pl.getId());
            patientDetails1.setFirstName(pl.getFirstName());
            patientDetails1.setLastName(pl.getLastName());
            patientDetails1.setMrn(pl.getMrn());
            patientDetails1.setFin(pl.getFin());
            patientDetailsList1.add(patientDetails1);
        }
        Child child = new Child();
        List<Child> childList = new ArrayList<>();
        childList.add(child);
        child.setChildDetails(patientDetailsList1);
        System.out.println(child);
        patientResult.setChild(childList);
        List<Category> categoryList=null;
        ResultDAO resultDAO=new ResultDAOImpl();
        Result result=null;
        List<Result> resultModelList=null;
        ResultResponse resultDto=new ResultResponse();
        for(PatientDetails patientDetail:patientDetailsList1){
            BabyResultDAOImpl babyResultDAO=new BabyResultDAOImpl();
            BabyResultResponse babyResultResponse = babyResultDAO.getBabyPatientByChildId(patientDetail.getId());
            if(null!=babyResultResponse){
                patientDetail.setResultCopiedDateTime(babyResultResponse.getDateTime());
            }
            else{
                List<CategoryResponse> categoryResponseList =patientDto.getCategory();
                categoryList=new ArrayList<>();
                for(CategoryResponse categoryResponse : categoryResponseList)
                {
                    Category category=new Category();
                    category.setId(categoryResponse.getId());
                    category.setDisplayName(categoryResponse.getDisplayName());
                    List<ResultResponse> resultList = categoryResponse.getResult();
                    resultModelList=new ArrayList<>();
                    for(ResultResponse resultDto1:resultList)
                    {
                        result=new Result();
                        result.setId(resultDto1.getId());
                        result.setDisplayName(resultDto1.getDisplayName());
                        result.setValue(resultDto1.getValue());
                        resultModelList.add(result);
                    }
                    category.setResult(resultModelList);
                    categoryList.add(category);
                }
                patientResult.setCategory(categoryList);
            }
        }
        patientResult.setPatientt(patient);
        patientResult.setChild(childList);
        return Response.ok().entity(patientResult).build();
    }
}
