package com.javabasic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangyuj
 * @date 2020/10/19
 **/
public class NIO {
    public static void main(String[] args) {

    }

    public static void processServerSocketChannel() throws IOException {
        //I/O多路复用器创建
        //Selector,ServerSocketChannel,SocketChannel使用SelectorProvider创建
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int select = selector.select();
            if (select==0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isAcceptable()) {

                }
            }
        }
    }
}
