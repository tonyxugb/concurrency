package part2_stream.chapter4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by xugebing on 2017/9/25.
 */
public class StreamTest {

    @Test
    public void testThreeHighCaloriesDish(){
        List<String> threeHighCaloriesDishNames =
                StreamTestData.menu.stream().filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloriesDishNames);
    }

}
