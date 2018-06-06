import heap.stark.proxy.cglib.CglibProxy;
import heap.stark.proxy.interfaces.SayHello;
import heap.stark.proxy.interfaces.impl.SayHelloImpl;
import heap.stark.proxy.jdkProxy.JDKProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;


/**
 * Created by wangzhilei3 on 2017/12/29.
 */
public class ProxyTest {
    @Test
    public void CglibTest() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SayHelloImpl.class);
        enhancer.setCallback(new CglibProxy());
        SayHelloImpl s = (SayHelloImpl) enhancer.create();
        s.say();
        String returnHello = s.returnHello();
        assert (returnHello == "hello");
    }

    @Test
    public void jdkTest() {
        SayHello sayHello = (SayHello) Proxy.newProxyInstance(
                SayHelloImpl.class.getClassLoader(),
                new Class[]{SayHello.class},
                new JDKProxy());

        sayHello.say();
        String result = sayHello.returnHello();

        assert (result == "hello");
    }
}
