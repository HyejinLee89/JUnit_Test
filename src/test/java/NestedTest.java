import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class NestedTest {
    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated woth new Stack() ")
    void isInstanciatedWithNew(){
        new Stack();
    }

    @Nested
    @DisplayName("When new ")
    class WhenNew{
        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty ")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException When popped ")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class, ()->stack.pop());
        }

        @Test
        @DisplayName("throws EmptyStackException When peeked ")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class, ()->stack.peek());
        }

        @Nested
        @DisplayName("after pushing an element ")
        class AfterPushing{
            String anElement = "an element";

            @BeforeEach
            void pushAnElement(){
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty ")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty ")
            void returnElementWhenPopped(){
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty ")
            void returnElementWhenPeeked(){
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }

        }

    }
}