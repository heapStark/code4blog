package heap.stark.redis.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * blogcode
 * Created by wangzhilei3 on 2018/1/3.
 */
public class JedisClientPool {

    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static JedisPoolConfig config = new JedisPoolConfig();

        static {
            config.setMaxTotal(2);
        }

        private static JedisPool jedisPool = new JedisPool(config,
                "localhost", 6379, 5000);
    }
    //获取连接池
    public static JedisPool getPool() {
        return SingletonHolder.jedisPool;
    }


}
