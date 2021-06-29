package com.resultcopy;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author AC089545
 * The class is created to set the result request to copy the result details to baby.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultRequest {
    private String displayName;
    private String value;
}
