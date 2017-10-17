package chapter10_optional;


import org.junit.Test;

import java.util.Optional;

/**
 * Created by xugebing on 2017/10/10.
 */
public class OptionalTest {

    public static void main(String[] args) {

        //使用map从Optional对象中提取和转换值

    }

    @Test
    public void testCreateOptional(){
        //创建一个空的Optional
        Optional<Car> optCar = Optional.empty();

        //依据一个非空值，创建Optional
        Car car = new Car();
        Optional<Car> optCar2 = Optional.of(car);

        //可接受null的Optional
        car = null;
        Optional<Car> optCar3 = Optional.ofNullable(car);
    }

    @Test
    public void testGetValue(){
        Car car = new Car();
        car.setId("1");
        car.setColor("Red");
        Optional<Car> optCar = Optional.of(car);
        Optional<String> optColor = optCar.map(Car::getColor);
        System.out.println(optColor.get());
    }

    @Test
    public void testDefault(){
        Optional<String> opt = Optional.ofNullable(null);
        System.out.println(opt.orElse("空"));
        Optional<Car> opt2 = Optional.of(new Car("yellow"));
        Car c = opt2.orElse(new Car("red"));
        System.out.println(c);
        opt2 = Optional.empty();
        c = opt2.orElse(new Car("red"));
        System.out.println(c);
    }

}
