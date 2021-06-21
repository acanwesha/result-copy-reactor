package com.resultcopy.rest.api.impl;

import com.resultcopy.BabyRequest;
import com.resultcopy.BabyResultResponse;
import com.resultcopy.CategoryRequest;
import com.resultcopy.ResultRequest;
import com.resultcopy.rest.model.BabyResult;
import com.resultcopy.rest.model.CategoryPost;
import com.resultcopy.rest.model.CategoryPostResult;
import com.resultcopy.service.dao.BabyResultDAO;
import com.resultcopy.service.impl.BabyResultDAOImpl;
import com.resultcopy.rest.api.*;

import com.resultcopy.rest.api.NotFoundException;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class CopyResultsApiServiceImpl extends CopyResultsApiService {
    @Override
    public Response copyResultsPost(BabyResult body, SecurityContext securityContext) throws NotFoundException {
        BabyResultDAO babyResultDAO=new BabyResultDAOImpl();
        BabyRequest babyRequest = new BabyRequest();

        CategoryPost categoryPost=null;

        CategoryPostResult categoryPostResult=null;

        BabyResult babyResult=new BabyResult();
        List<CategoryPost> categoryList= new ArrayList<>();
        List<CategoryPostResult> categoryPostResultList= new ArrayList<>();

        babyResult.setChildId(babyRequest.getChildId());

        List<CategoryRequest> categoryRequestList=babyRequest.getCategory();
        for(CategoryRequest categoryRequest:categoryRequestList){
            categoryPost=new CategoryPost();
            categoryPost.setDisplayName(categoryRequest.getDisplayName());
            List<ResultRequest> resultRequestList=categoryRequest.getResult();
            for(ResultRequest resultList:resultRequestList){
                categoryPostResult=new CategoryPostResult();
                categoryPostResult.setDisplayName(resultList.getDisplayName());
                categoryPostResult.setValue(resultList.getValue());
                categoryPostResultList.add(categoryPostResult);
            }
            categoryPost.setResult(categoryPostResultList);
            categoryList.add(categoryPost);
        }
        babyResult.setCategory(categoryList);
/////////////////////////////////////////////////////////////////////
        babyRequest=babyResultDAO.createBabyResult(body);
        return Response.ok().entity(babyResult).build();

    }
}
