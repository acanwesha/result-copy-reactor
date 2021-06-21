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
public class CategoryResponse implements Serializable {
    private int id;
    private String displayName;
    private List<ResultResponse> result = new ArrayList<>();
}
