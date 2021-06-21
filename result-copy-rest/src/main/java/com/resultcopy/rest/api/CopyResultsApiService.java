package com.resultcopy.rest.api;

import com.resultcopy.rest.model.BabyResult;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public abstract class CopyResultsApiService {
    public abstract Response copyResultsPost(BabyResult body, SecurityContext securityContext) throws NotFoundException;
}
