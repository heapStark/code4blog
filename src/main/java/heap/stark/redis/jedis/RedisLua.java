package heap.stark.redis.jedis;

import com.google.common.io.CharStreams;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class RedisLua {
    @Test
    public void luaTest() throws IOException {
        JedisPool jedisPool = JedisClientPool.getPool();
        Jedis jedis = jedisPool.getResource();
        String script = loadScriptString("script.lua");
        long result = (long) jedis.eval(script, Arrays.asList("key"),Arrays.asList("12","12"));
        Assert.assertEquals(result,1);
        String set = jedis.scriptLoad("return redis.call('set', KEYS[1],ARGV[1])");
        String get = jedis.scriptLoad("return redis.call('get', KEYS[1])");
        jedis.evalsha(set,1,"hello","world","wzl");
        Assert.assertEquals(jedis.evalsha(get,1,"hello"),"world");
    }

    private String loadScriptString(String fileName) throws IOException {
        Reader reader = new InputStreamReader(RedisLua.class.getClassLoader().getResourceAsStream(fileName));
        return CharStreams.toString(reader);
    }
}
