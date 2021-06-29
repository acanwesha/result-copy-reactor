package com.resultcopy;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author AC089545
 * The class is created to set the category request to copy the category details to baby.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryRequest {
    private String displayName;
    private List<ResultRequest> result ;
}
