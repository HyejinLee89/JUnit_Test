import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DynamicTest {
    private Person person = new Person("Luther", "Benjamin");

    //This will result in a JUnitException
    @TestFactory
    List<String> dynamicTestsWithInvalidReturnType(){
        return Arrays.asList("Hello");
    }

    @TestFactory
    Collection<org.junit.jupiter.api.DynamicTest> dynamicTestFromCollection(){
        person.setAge(33);
        return Arrays.asList(
                dynamicTest("1 : ", ()->assertTrue(person.getFirstName().startsWith("L"))),
                dynamicTest("2 : ", ()->assertEquals(33,person.getAge()))
        );
    }

    @TestFactory
    Iterable<org.junit.jupiter.api.DynamicTest> dynamicTestFromIterable(){
        person.setAge(37);
        return Arrays.asList(
                dynamicTest("3 : ", ()->assertTrue(person.getFirstName().startsWith("L"))),
                dynamicTest("4 : ", ()->assertEquals(37,person.getAge()))
        );
    }


    @TestFactory
    Stream<org.junit.jupiter.api.DynamicTest> dynamicTestFromStream(){

        return Stream.of( new Person("Juliette", "Scott"),
                          new Person("Leonardo", "Curie")).map(tt->dynamicTest(
                                  "test " + tt.getFullName(), ()->{
                                      assertEquals(8,tt.getFirstName().length());
                }
                ));
    }

}
