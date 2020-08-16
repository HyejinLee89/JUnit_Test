import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

class Message{
    String messageString;
    Message(String messageStr){
        messageString = messageStr;
    }

    public String getMessage(){
        return messageString;
    }
}

public class ToMessageConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        checkSource(source);
        checkTarget(targetType);

        String sourceString = (String)source;
        return new Message(sourceString);
    }

    private void checkTarget(Class<?> targetType){
        System.out.println(targetType.getName());
        if (!targetType.equals(Message.class))
            throw new ArgumentConversionException("Can only convert to Message");

    }

    private void checkSource(Object source){
        if (source == null){
            throw new ArgumentConversionException("Cannot convert null source object");
        }

        if (!source.getClass().equals(String.class)){
            throw new ArgumentConversionException("Cannot convert source object because it's not a string");
        }

        String sourceString = ((String)source).trim();
        if(sourceString.isEmpty())
            throw new ArgumentConversionException("Cannot convert empty source object");

    }

}

class IsDivisibleBy extends TypeSafeMatcher<Integer> {
    int value;

    @Override
    protected boolean matchesSafely(Integer item) {
        return item % value == 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Can not divided by " + value);

    }

    static Matcher<Integer> divisibleBy(Integer divider) {
        IsDivisibleBy matcher = new IsDivisibleBy();
        matcher.value = divider;
        return matcher;
    }
}