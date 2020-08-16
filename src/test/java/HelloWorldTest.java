import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloWorldTest {
    @BeforeAll
    static void beforeAllPrint(){
        System.out.println("Before All---");

    }

    @BeforeEach
    void beforeEachPrint(){
        System.out.println(" test is started~~~ ");

    }

    @AfterAll
    static void AfterAllPrint(){
        System.out.println(".........All Ends...");

    }

    @AfterEach
    void afterEachPrint(){
        System.out.println(" test ends!");

    }


    @Order(1)
    @Test
    void printNumTest() {
        System.out.println("main test");
        assertEquals("Hello 2", new HelloWorld().printNum(2));
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(ints = {9, 7, 5, 3, 1})
    void printNumTest(int num) {
        System.out.printf("%d is comming.%n", num);
    }

    @Order(6)
    @Test
    void isGreaterTest() {
        System.out.println(" isGreater() Test.");
    }


    @Order(3)
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void test1(int num){
        System.out.println(num + "th test!!");
    }

    @Order(5)
    @Test
    void test2(){
        System.out.println("test2!!");
        assertEquals("HelloWorld", new HelloWorld().getClassName());
    }

    @Order(4)
    @Test
    void test3(){
        System.out.println("test3!!");
    }

}

@ExtendWith(bExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests{

    @Test
    @Order(4)
    void nullValues(){
        System.out.println("nullValues() - order 4");
    }

    @Test
    @Order(2)
    void emptyValues(){
        System.out.println("emptyValues() - order 2");
    }


    @Test
    @Order(1)
    void validValues(){
        System.out.println("validValues() - order 1");
    }


    @Test
    public void extendWithTest(){
        System.out.println("ExtendWith Test");
    }

}

class bExtension implements AfterEachCallback, BeforeTestExecutionCallback , AfterAllCallback{

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("ExtendWith Execution");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("ExtendWith after each Execution");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("ExtendWith after all Execution");
    }
}