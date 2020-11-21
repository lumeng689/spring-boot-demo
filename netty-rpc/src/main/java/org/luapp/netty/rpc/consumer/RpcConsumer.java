package org.luapp.netty.rpc.consumer;

import org.luapp.netty.rpc.api.IRpcHelloService;
import org.luapp.netty.rpc.api.IRpcService;
import org.luapp.netty.rpc.consumer.proxy.RpcProxy;

/**
 * @author: 86150
 * @create: 2020/11/21
 **/
public class RpcConsumer {
    public static void main(String[] args) {
        IRpcHelloService rpcHello = RpcProxy.create(IRpcHelloService.class);

        System.out.println(rpcHello.hello("Tom 老师"));

        IRpcService service = RpcProxy.create(IRpcService.class);

        System.out.println("8 + 2 = " + service.add(8, 2));
        System.out.println("8 - 2 = " + service.sub(8, 2));
        System.out.println("8 * 2 = " + service.mult(8, 2));
        System.out.println("8 / 2 = " + service.div(8, 2));
    }
}
