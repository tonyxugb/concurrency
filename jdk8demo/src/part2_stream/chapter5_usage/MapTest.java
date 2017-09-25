package part2_stream.chapter5_usage;

import org.junit.Test;
import part2_stream.chapter4.Dish;
import part2_stream.chapter4.StreamTestData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 映射
 *
 * Created by xugebing on 2017/9/25.
 */
public class MapTest {

    @Test
    public void testMap() {

        List<String> dishNames = StreamTestData.menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);


        List<Integer> dishNameLengths = StreamTestData.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);

    }

    @Test
    public void testFlatMap(){

        List<String> words = Arrays.asList("Hello", "world");

        List<String> list = words.stream().map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        /**
         *
         * .map(w -> w.split("")) 返回的是Stream<String[]>
         *
         * Arrays::stream可以将一个String[]做为入参，返回对应的Stream<String>
         *
         * flatMap做的就是把每一个元素（元素类型是Stream<String>）中的每个值都转换成一个流，
         *
         * 然后把每一个流连接起来成为一个大的流
         */
        System.out.println(list);
    }


}
