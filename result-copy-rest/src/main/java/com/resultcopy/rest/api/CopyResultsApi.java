package com.resultcopy.rest.api;

import com.resultcopy.rest.api.factory.CopyResultsApiServiceFactory;

import com.resultcopy.rest.model.BabyResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;


@Path("/copy-results")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class CopyResultsApi  {

    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "", description = "Copies the documented result from mother patient to baby.", tags={ "Copy Result" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Baby result copied."),
        
        @ApiResponse(responseCode = "400", description = "Bad Request."),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized.") })
    public Response copyResultsPost(@Parameter(in = ParameterIn.DEFAULT, description = "Baby result information that needs to be saved for a particular baby." ,required=true) BabyResult body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        CopyResultsApiService delegate = CopyResultsApiServiceFactory.getCopyResultsApi();
        return delegate.copyResultsPost(body,securityContext);
    }
}
