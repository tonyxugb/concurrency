package parameterizeBehavior;

/**
 * Created by xugebing on 2017/9/22.
 */
public class Apple {

    private String color;

    private int weight;

    public Apple(){

    }

    public Apple(String color, int weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
