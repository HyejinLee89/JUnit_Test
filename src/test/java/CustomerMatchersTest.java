import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

class CustomerMatchersTest{

    @Test
    void givenAnEvenInteger_whenDivisibleByTwo_thenCorrect(){
        Integer ten = 10;
        Integer five = 5;

        assertThat(ten, is(IsDivisibleBy.divisibleBy(five)));
    }

    @Test
    void givenAnOddInteger_whenNotDivisibleByTwo_thenCorrect(){
        Integer eleven = 11;
        Integer five = 5;

        assertThat(eleven, is(not(IsDivisibleBy.divisibleBy(five))));
    }
}
