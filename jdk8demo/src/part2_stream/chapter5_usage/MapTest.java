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
        System.out.println(list);
    }


}
