package org.luapp.netty.rpc.provider;

import org.luapp.netty.rpc.api.IRpcService;

/**
 * @author: 86150
 * @create: 2020/11/21
 **/
public class RpcServiceImpl implements IRpcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
