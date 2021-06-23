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

        BabyResult babyResult=new BabyResult();
        List<CategoryRequest> categoryList= new ArrayList<>();
        List<CategoryPostResult> categoryPostResultList = null;

        CategoryRequest categoryRequest=null;
        ResultRequest resultRequest=null;
        BabyRequest babyRequest = new BabyRequest();
        List<ResultRequest> resultDtoList=null;

        babyRequest.setChildId(babyResult.getChildId());
        List<CategoryPost> categoryPostList=babyResult.getCategory();
        for(CategoryPost category:categoryPostList){
            categoryRequest=new CategoryRequest();
            categoryRequest.setDisplayName(category.getDisplayName());
            List<CategoryPostResult> resultRequestList=category.getResult();
            for(CategoryPostResult resultList:resultRequestList){
                resultRequest= new ResultRequest();
                resultDtoList=new ArrayList<>();
                resultRequest.setDisplayName(resultList.getDisplayName());
                resultRequest.setValue(resultList.getValue());
                resultDtoList.add(resultRequest);
            }
            categoryRequest.setResult(resultDtoList);
            categoryList.add(categoryRequest);
        }
        babyRequest.setCategory(categoryList);
        babyResultDAO.createBabyResult(babyRequest);
        return Response.ok().entity(body).build();

    }
}
