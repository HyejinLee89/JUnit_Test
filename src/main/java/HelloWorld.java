import java.util.Random;

public class HelloWorld {
    private Random generator;

    public static void main(String[] arg){
        System.out.println("Hello World!!!!!\nThis is JUNIT Test program.");
        Person p = new Person("IntelliJ", "Maven");
        System.out.println("It runs on "+p.getFullName());

    }

    public String printNum(int num){
        return "Hello "+num;
    }

    public boolean isGreater(int num1, int num2){
        return num1>num2;
    }

    public String getClassName(){
        return "HelloWorld";
    }

    public int rollDice(){
        return generator.nextInt(6)+1;
    }
}
