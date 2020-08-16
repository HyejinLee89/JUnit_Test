import org.mockito.ArgumentMatcher;

class LessThanOrEqualToMatcher implements ArgumentMatcher<Integer> {
    int value;

    LessThanOrEqualToMatcher(int value){
        this.value = value;
    }

    @Override
    public boolean matches(Integer argument){
        System.out.println(argument);
        return argument <= value;
    }
}
