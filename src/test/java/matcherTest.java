import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.leq;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class MyMatchers{
    static ArgumentMatcher<Integer> isLessThanOrEqualTo(int value){
        System.out.println("isLessThatnOrEqualTo" + value);
        return new LessThanOrEqualToMatcher(value);
    }
}


class matcherTest {

    @Test
    void testMatchers() {
        Person p = mock(Person.class);

        doThrow(IllegalArgumentException.class).when(p).setAge(leq(19));

        assertDoesNotThrow(() -> p.setAge(20));
        assertThrows(IllegalArgumentException.class, () -> p.setAge(18));
    }

    @Test
    void testCustomerMatchers() {
        Person p = mock(Person.class);

        doThrow(IllegalArgumentException.class).when(p).setAge(intThat(MyMatchers.isLessThanOrEqualTo(5)));

        assertDoesNotThrow(() -> p.setAge(6));
        assertThrows(IllegalArgumentException.class, () -> p.setAge(3));

    }
}