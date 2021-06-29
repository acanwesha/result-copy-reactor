package com.resultcopy;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @author AC089545
 * Information about the patient.
 */
@Getter
@Setter
public class PatientResponse implements Serializable {
    private PatientDetailsResponse patientDetails;
}
