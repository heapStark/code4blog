package heap.stark.tool;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesDemo.class);

    @Test
    public void main() throws IOException {
        InputStream in = PropertiesDemo.class.getClassLoader()
                .getResourceAsStream("test.properties");
        Properties pro = new Properties();
        pro.load(in);
        Assert.assertEquals(pro.getProperty("123"), "123");
    }
}
