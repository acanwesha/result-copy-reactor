package com.resultcopy.rest.api;

import com.resultcopy.rest.api.factory.PatientResultsApiServiceFactory;

import com.resultcopy.rest.model.PatientResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import java.io.IOException;


@Path("/patient-results")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class PatientResultsApi  {
    @GET
    @Path("/{patientId}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Returns the patient details, child details, categories and result details by Patient identifier.", tags={ "Patient Result" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully retrieved patient, child and result details.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResult.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request patientId must be a positive value."),
        
        @ApiResponse(responseCode = "404", description = "A Patient with the specified Id was not found.") })
    public Response patientResultsPatientIdGet(@Parameter(in = ParameterIn.PATH, description = "A unique identifier of patient to fetch the patient details having the same identifier provided in the path url.",required=true) @PathParam("patientId") String patientId
,@Context SecurityContext securityContext)
            throws NotFoundException, IOException {
        PatientResultsApiService delegate = PatientResultsApiServiceFactory.getPatientResultsApi();
        return delegate.patientResultsPatientIdGet(patientId,securityContext);
    }
}
