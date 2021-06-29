package com.resultcopy;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author AC089545
 * Sets the baby request body that is to be copied to baby.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BabyRequest {
    private Integer childId ;
    private List<CategoryRequest> category;
}
