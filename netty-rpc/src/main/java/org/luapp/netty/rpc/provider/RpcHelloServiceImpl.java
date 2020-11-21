package org.luapp.netty.rpc.provider;

import org.luapp.netty.rpc.api.IRpcHelloService;

/**
 * @author: 86150
 * @create: 2020/11/21
 **/
public class RpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
