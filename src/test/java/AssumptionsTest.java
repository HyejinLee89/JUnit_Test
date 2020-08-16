import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {
    private final Person person = new Person("Harris","Ford");
    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));

    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("WINOWS".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    void testInAllEnvironments() {

        assumingThat("WINDOWS".equals("WINDOWS"),
                () -> {
                    System.out.println("WiNDOWS : " + person.getFullName().toString());
                    assertEquals(4, person.getFullName().length());
                });
        assertEquals(10, person.getFullName().length());
        assumingThat("WINDOWS".equals("WDOWS"),
                () -> {
                    System.out.println("WDOWS : " + person.getFullName().toString());
                });

        System.out.println(person.getFirstName().toString());
        System.out.println(person.getLastName().toString());

    }
}
