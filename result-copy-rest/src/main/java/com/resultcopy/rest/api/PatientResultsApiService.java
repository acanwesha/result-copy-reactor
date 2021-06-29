package com.resultcopy.rest.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")
public abstract class PatientResultsApiService {
    public abstract Response patientResultsPatientIdGet(String patientId,SecurityContext securityContext) throws NotFoundException;
}
