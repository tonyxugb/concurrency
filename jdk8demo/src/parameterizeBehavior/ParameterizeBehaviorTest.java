package parameterizeBehavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化
 *
 * Created by xugebing on 2017/9/22.
 */
public class ParameterizeBehaviorTest {

    public static void main(String[] args) {

        List<Apple> inventory = prepareApplesForTest();

        ApplePredicate p = new AppleWeightPredicate();

        List<Apple> result = filterApples(inventory, p);

        System.out.println(result.size());

    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {

        List<Apple> apples = new ArrayList<Apple>();
        for(Apple a : inventory){
            if(p.test(a)){
                apples.add(a);
            }
        }
        return apples;
    }

    private static List<Apple> prepareApplesForTest() {
        Apple a = new Apple("green", 200);
        Apple b = new Apple("red", 150);
        Apple c = new Apple("yellow", 250);

        List<Apple> list = new ArrayList<Apple>();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }


}
