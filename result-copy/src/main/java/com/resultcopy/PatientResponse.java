package com.resultcopy;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class PatientResponse implements Serializable {
    private PatientDetailsResponse patientDetails;
}
