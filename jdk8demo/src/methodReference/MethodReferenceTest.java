package methodReference;

/**
 * Created by xugebing on 2017/9/21.
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        String inStr = "lambda add power to Java";
        //MyStringOps::strReverse整体相当于接口StringFunc的一个实现类的实例；
        //MyStringOps::strReverse中的代码相当于实现了接口StringFunc的抽象方法;
        //相当于把MyStringOps::strReverse中代码传递给了stringOp方法
        StringFunc sf = MyStringOps::strReverse;

        String outStr = stringOp(sf, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reserved: " + outStr);
    }

    //行为参数化
    public static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
}
