import com.resultcopy.PatientDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatientDetailsResponseTest {
    @Test
    public void testSetDescription() {
        PatientDetailsResponse patientDetailsResponse=new PatientDetailsResponse();
        patientDetailsResponse.setId(1);
        patientDetailsResponse.setFirstName("EMMA");
        patientDetailsResponse.setLastName("ESPINOSA");
        patientDetailsResponse.setMrn("MX123");
        patientDetailsResponse.setFin("MH123");
        Assertions.assertEquals(1, patientDetailsResponse.getId());
        Assertions.assertEquals("EMMA", patientDetailsResponse.getFirstName());
        Assertions.assertEquals("ESPINOSA", patientDetailsResponse.getLastName());
        Assertions.assertEquals("MX123", patientDetailsResponse.getMrn());
        Assertions.assertEquals("MH123", patientDetailsResponse.getFin());
    }
}
