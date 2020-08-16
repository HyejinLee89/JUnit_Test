public class SingletonClass {
    private static SingletonClass sInstance;

    private SingletonClass() {
        //do somethings
    }

    public static synchronized SingletonClass getInstance() {
        if (sInstance == null) {
            sInstance = new SingletonClass();
        }
        return sInstance;
    }

    public boolean methodToTest() {
        return true;
    }

    public String getSomeString() {
        return "singleton object";
    }
}
