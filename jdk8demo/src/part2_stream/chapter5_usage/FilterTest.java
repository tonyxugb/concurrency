package part2_stream.chapter5_usage;

import org.junit.Test;
import part2_stream.chapter4.Dish;
import part2_stream.chapter4.StreamTestData;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 筛选
 * <p>
 * Created by xugebing on 2017/9/25.
 */
public class FilterTest {

    /**
     * 谓词筛选
     */
    @Test
    public void testFilter() {
        List<Dish> dishes = StreamTestData.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(dishes);
    }

    /**
     * 筛选各异的元素
     */
    @Test
    public void testDistinct() {

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 截短流
     */
    @Test
    public void testLimit() {
        StreamTestData.menu.stream().filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
    }


    @Test
    public void testSkip(){

        List<Dish> dishes = StreamTestData.menu.stream().filter(d -> d.getCalories() > 500)
                .skip(2)
                .collect(toList());

        System.out.println(dishes);

    }
}
