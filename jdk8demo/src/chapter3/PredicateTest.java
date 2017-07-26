package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by xugebing on 2017/7/26.
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> nonEmptyStringPredicate = (String s) -> s != null && !s.trim().equals("");

        List<String> sList = new ArrayList<String>();
        sList.add("a");
        sList.add("b");
        sList.add("");
        sList.add("      ");

        List<String> nonEmptyList = new ArrayList<>();

        for(String ss : sList){
            if (nonEmptyStringPredicate.test(ss)) {
                nonEmptyList.add(ss);
            }
        }

        System.out.println(nonEmptyList);

    }
}
