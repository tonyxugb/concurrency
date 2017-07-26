package chapter3;

/**
 * Created by xugebing on 2017/7/26.
 */
public class LambdaTest {

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("Hello World 1");

        process(r1);

        process(() -> System.out.println("Hello World 2"));

    }
}
