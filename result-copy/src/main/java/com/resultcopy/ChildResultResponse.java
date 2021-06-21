package com.resultcopy;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildResultResponse {
    private Integer resultId;
    private Integer childId;
    private String value;
}
