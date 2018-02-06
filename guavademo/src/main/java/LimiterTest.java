import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by xugebing on 2017/12/23.
 */
public class LimiterTest {

    @Test
    public void testRateLimiter() {

        RateLimiter limiter = RateLimiter.create(5);

        System.out.println(limiter.acquire());

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

    }

    @Test
    public void testRateLimiter2(){

        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

    }

    @Test
    public void testRateLimiter3() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(2);

        System.out.println(limiter.acquire());

        Thread.sleep(2000L);

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }

    @Test
    public void testRateLimiter4() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(5, 5000, TimeUnit.MILLISECONDS);

        for(int i=0; i<100; i++){
            System.out.println(limiter.acquire());
        }

        // 睡眠1秒后，即便桶里已经有了5个，也不能立即使用，同样需要在1秒内逐步达到平均速率
//        Thread.sleep(5000L);
//
//        for(int i=0; i<50; i++){
//            System.out.println(limiter.acquire());
//        }



    }
}
