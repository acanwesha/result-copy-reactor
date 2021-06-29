package com.resultcopy;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author AC089545
 * Baby result information that is to be copied and be linked to the baby.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BabyResultResponse {
    private Integer childId;
    private String  value;
    private String categoryName;
    private String  resultName;
    private Date dateTime;
}
