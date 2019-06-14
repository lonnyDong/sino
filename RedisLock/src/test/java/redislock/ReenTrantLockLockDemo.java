package redislock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReenTrantLockLockDemo {

    public static String GOODS_BALANCE_LOCK = "lock_save_money";


    @Autowired
    RedisTemplate redisTemplate;

    private static AtomicInteger count = new AtomicInteger(0);

    public final String ACCOUNT_NAME = "account_pub";

    ReentrantLock lock = new ReentrantLock();
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testByGoods() {
//		CyclicBarrier barrier0 = new CyclicBarrier(2);


        Thread thread = new Thread(() -> {
            int savecount = 0;
            for (int i = 0; i < 100; i++) {
                boolean res = saveMoney();
                if (res) {
                    ++savecount;
                }
            }
            System.out.println("存钱成功的次数：" + savecount);
        }, "my thread 001");

        Thread thread2 = new Thread(() -> {
            int fatchcount = 0;

            for (int i = 0; i < 100; i++) {
                boolean b = fetchMoney();
                if (b) {
                    ++fatchcount;
                }
            }
            System.out.println("取钱成功的次数：" + fatchcount);
        }, "my thread 002");

        thread.start();
        thread2.start();

        while (true) {

        }

    }

    /**
     * 每次存入1块钱
     */
    private boolean saveMoney() {

        try {
            lock.lock();
            System.out.println("开始存钱:"+Thread.currentThread().getName());
            Object o = redisTemplate.opsForValue().get(ACCOUNT_NAME);
            if (o == null) {
                Thread.sleep(100);
                System.out.println("存钱账户余额为零：");
                redisTemplate.opsForValue().set(ACCOUNT_NAME, 1);
                return true;
            } else {
                int count = (Integer) o;
                redisTemplate.opsForValue().set(ACCOUNT_NAME, count + 1);
                return true;
            }
        } catch (Exception e) {
            System.out.println("账户存钱失败：" + e.getMessage());

        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
				LOGGER.info("存钱释放锁失败：" +count.incrementAndGet());
            }
        }
        return false;
    }


    /**
     * 每次取1块钱
     */
    private boolean fetchMoney() {

        try {
            lock.lock();
            System.out.println("开始取钱:"+Thread.currentThread().getName());
            Object o = redisTemplate.opsForValue().get(ACCOUNT_NAME);
            if (o == null) {
                LOGGER.info("账户余额为零：");
                return false;
            } else {
                int count = (Integer) o;
                if(count<=0){
                    return false;
                }else{
                    redisTemplate.opsForValue().set(ACCOUNT_NAME, count - 1);
                    return true;
                }
            }
        } catch (Exception e) {
            LOGGER.info("账户取钱失败：" + e.getMessage());

        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
				LOGGER.info("释放锁失败：" + e.getMessage());
            }
        }
        return false;
    }

}
