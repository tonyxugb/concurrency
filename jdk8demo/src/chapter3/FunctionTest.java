package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by xugebing on 2017/7/26.
 */
public class FunctionTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("zhangsan","lisi","wangwu");

        Function<String, Integer> f = (String s) -> s.length();

        for(String ss : list){
            System.out.println(f.apply(ss));
        }

    }
}
