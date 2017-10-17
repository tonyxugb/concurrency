package chapter10_optional;

/**
 * Created by xugebing on 2017/10/10.
 */
public class Car {

    private String id;

    private String color;

    public Car(){

    }

    public Car(String color){
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
