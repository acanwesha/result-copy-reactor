package com.resultcopy;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResultResponse implements Serializable {
    private Integer id ;
    private String displayName ;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String value;
    private List<ChildResultResponse> childResult = new ArrayList<>();
}
