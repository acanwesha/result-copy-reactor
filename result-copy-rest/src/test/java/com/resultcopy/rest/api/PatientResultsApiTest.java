package com.resultcopy.rest.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/**
 * @author AC089545
 * Test case for {@link PatientResultsApi}
 */
@RunWith(MockitoJUnitRunner.class)
class PatientResultsApiTest {
    private @Mock SecurityContext securityContext;

    /**
     * Test to check whether the response of patientId is returned successfully.
     * @throws NotFoundException if patientId not found.
     */
    @Test
    void testPatientResultsPatientId() throws com.resultcopy.rest.api.NotFoundException, IOException {
        String patientId = "1";
        Response response = new PatientResultsApi().patientResultsPatientIdGet(patientId, securityContext);
        System.out.println(response);
        Assertions.assertEquals(200, response.getStatus());

    }
}