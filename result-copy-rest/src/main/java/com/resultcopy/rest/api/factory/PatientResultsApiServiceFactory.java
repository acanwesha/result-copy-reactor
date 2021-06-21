package com.resultcopy.rest.api.factory;

import com.resultcopy.rest.api.PatientResultsApiService;
import com.resultcopy.rest.api.impl.PatientResultsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class PatientResultsApiServiceFactory {
    private final static PatientResultsApiService service = new PatientResultsApiServiceImpl();

    public static PatientResultsApiService getPatientResultsApi() {
        return service;
    }
}
