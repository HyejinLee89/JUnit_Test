import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A special test case")
public class DisplayNameTest {
    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces(){
        Person john = new Person("John","Smith");
        assertTrue(john.getFullName().contains(" "));
    }

    @Test
    @DisplayName("Custom test name containing special character")
    void testWithDisplayNameContaininSpecialCharcter(){
        Person john = new Person("John","Smith_");
        assertTrue(john.getFullName().contains("_"));
    }
}
