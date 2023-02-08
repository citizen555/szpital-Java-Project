import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DataCorectnessTest {

    @Test
    public void peselTest() {
        //valid PESEL number
        assertTrue(DataCorectness.pesel("12345678901"));
        //invalid PESEL number
        assertFalse(DataCorectness.pesel("1234567890"));
    }

    @Test
    public void nameTest() {
        //valid name
        assertTrue(DataCorectness.name("John"));
        //invalid name
        assertFalse(DataCorectness.name("John1"));
    }

    @Test
    public void dateTest() {
        //valid date
        assertTrue(DataCorectness.date("2021-12-31"));
        //invalid date
        assertFalse(DataCorectness.date("2021-12-32"));
    }

    @Test
    public void timeTest() {
        //valid time
        assertTrue(DataCorectness.time("12:30:00"));
        //invalid time
        assertFalse(DataCorectness.time("25:30:00"));
    }

    @Test
    public void postCodeTest() {
        //valid postcode
        assertTrue(DataCorectness.postCode("00-000"));
        //invalid postcode
        assertFalse(DataCorectness.postCode("00000"));
    }

    @Test
    public void emailTest() {
        //valid email
        assertTrue(DataCorectness.email("example@email.com"));
        //invalid email
        assertFalse(DataCorectness.email("example@.com"));
    }

    @Test
    public void telephoneTest() {
        //valid telephone number
        assertTrue(DataCorectness.telephone("123456789"));
        //invalid telephone number
        assertFalse(DataCorectness.telephone("12345678"));
    }

    @Test
    public void containsNumberAndCharsTest() {
        //valid string
        assertTrue(DataCorectness.containsNumberAndChars("John"));
        //invalid string
        assertFalse(DataCorectness.containsNumberAndChars("John1"));
    }

    @Test
    public void salaryTest() {
        //valid salary
        assertTrue(DataCorectness.salary("1000"));
        //invalid salary
        assertFalse(DataCorectness.salary("1,000"));
    }

}