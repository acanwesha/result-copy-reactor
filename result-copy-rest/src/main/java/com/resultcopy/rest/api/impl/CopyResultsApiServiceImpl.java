package com.resultcopy.rest.api.impl;

import com.resultcopy.BabyResultResponse;
import com.resultcopy.rest.model.BabyResult;
import com.resultcopy.service.dao.BabyResultDAO;
import com.resultcopy.service.impl.BabyResultDAOImpl;
import com.resultcopy.rest.api.*;

import com.resultcopy.rest.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class CopyResultsApiServiceImpl extends CopyResultsApiService {
    @Override
    public Response copyResultsPost(BabyResult body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        BabyResultResponse babyResultDto = null;
        BabyResultDAO babyResultDAO=new BabyResultDAOImpl();
//babyResultDto=babyResultDAO.createBabyResult(body);
        return Response.ok().entity(babyResultDto).build();

    }
}
