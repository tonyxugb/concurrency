package parameterizeBehavior;

/**
 * Created by xugebing on 2017/9/22.
 */
public class AppleColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
