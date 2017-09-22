package parameterizeBehavior;

/**
 * Created by xugebing on 2017/9/22.
 */
public class AppleWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
