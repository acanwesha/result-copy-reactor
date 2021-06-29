package com.resultcopy.rest.api;

/**
 * This class handles exception.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T12:22:56.778Z[GMT]")public class ApiException extends Exception{
    private int code;

    /**
     * ApiException method sets the message based on generated code.
     * @param code This is the response code generated from the Api Response Message.
     * @param message  This is the message returned on entering a code.
     */
    public ApiException (int code, String message) {
        super(message);
        this.code = code;
    }
}
