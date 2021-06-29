package com.resultcopy.rest.api.factory;

import com.resultcopy.rest.api.PatientResultsApiService;
import com.resultcopy.rest.api.impl.PatientResultsApiServiceImpl;

/**
 * This is the factory method that initializes the service of {@link PatientResultsApiService}
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class PatientResultsApiServiceFactory {
    private final static PatientResultsApiService service = new PatientResultsApiServiceImpl();

    /**
     * This is the factory method that initializes the service.
     * @return service {@link PatientResultsApiService} it returns the service initialized.
     */
    public static PatientResultsApiService getPatientResultsApi() {
        return service;
    }
}
