package com.resultcopy.rest.api.factory;

import com.resultcopy.rest.api.CopyResultsApiService;
import com.resultcopy.rest.api.impl.CopyResultsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class CopyResultsApiServiceFactory {
    private final static CopyResultsApiService service = new CopyResultsApiServiceImpl();

    public static CopyResultsApiService getCopyResultsApi() {
        return service;
    }
}
