package com.resultcopy;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResultResponse {
    private PatientResponse patient = new PatientResponse();
    private List<ChildResponse> child = new ArrayList<>();
    private List<CategoryResponse> category = new ArrayList<>();
}
