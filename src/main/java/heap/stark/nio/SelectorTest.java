package heap.stark.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Set;

/**
 * blogcode
 * Created by wangzhilei3 on 2018/1/2.
 */
public class SelectorTest {
    /**
     *
     */
    @Test
    public void selectorTest() throws Exception{


        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080), 1024);
        serverSocketChannel.configureBlocking(false);
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        socketChannel.configureBlocking(false);

        Selector selector1 = Selector.open();
        assert (socketChannel.keyFor(selector1)==null);

        Selector selector = Selector.open();
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
        assert (socketChannel.keyFor(selector)==key);
        key = key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);//修改interestOps
        assert (key.interestOps()==( SelectionKey.OP_READ|SelectionKey.OP_WRITE));
        assert (key.channel()==socketChannel);
        assert (key.selector()==selector);

        long readyCount = selector.select();
        assert (readyCount==1);

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        assert (selectionKeys.size()==1);
        assert (selectionKeys.iterator().next().isWritable());
        assert (!selectionKeys.iterator().next().isReadable());
        selectionKeys.iterator().next().cancel();
        selector.selectNow();//执行就绪检查过程，但不阻塞。如果当前没有通道就绪，它将立即返回0
        selector.select(1000);//阻塞十秒
        selector.select();//在没有通道就绪时将无限阻塞



        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.register(selector1, SelectionKey.OP_CONNECT);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT,new Date());


    }
}
