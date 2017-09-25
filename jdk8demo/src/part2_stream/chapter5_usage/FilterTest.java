package part2_stream.chapter5_usage;

import org.junit.Test;
import part2_stream.chapter4.Dish;
import part2_stream.chapter4.StreamTestData;

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
}
