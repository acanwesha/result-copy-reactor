package com.resultcopy;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Sets the result response for a particular child.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildResultResponse {
    private Integer resultId;
    private Integer childId;
    private String value;
}
