package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by xugebing on 2017/7/26.
 */
public class ConsumerTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> c = (Integer i) -> System.out.println(i+1);

        for(Integer ii : list){
            c.accept(ii);
        }
    }
}
