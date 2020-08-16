import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SingletonMockingTest {

    @Test
    public void testSingletonClassUsingDocallRealMethod() {
        SingletonClass singletonObject = mock(SingletonClass.class);
        Mockito.doCallRealMethod().when(singletonObject).methodToTest();
        Mockito.doCallRealMethod().when(singletonObject).getSomeString();

        assertTrue(singletonObject.methodToTest());
        assertEquals("singleton object",singletonObject.getSomeString());
    }

    @Test
    public void testSingletonClassUsingHandlerClass(){
        SingletonClass singletonObject = mock(SingletonClass.class);
        doReturn("singleton class").when(singletonObject).getSomeString();
        when(singletonObject.methodToTest()).thenReturn(false);

        SingletonHandler handler = new SingletonHandler(singletonObject);

        assertTrue(handler.isTestable());
        assertEquals("singleton object",handler.getString());
    }
}