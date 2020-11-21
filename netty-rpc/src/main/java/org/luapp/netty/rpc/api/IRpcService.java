package org.luapp.netty.rpc.api;

/**
 * @author: 86150
 * @create: 2020/11/21
 **/
public interface IRpcService {
    /**
     * 加
     */
    public int add(int a, int b);

    /**
     * 减
     */
    public int sub(int a, int b);

    /**
     * 乘
     */
    public int mult(int a, int b);

    /**
     * 除
     */
    public int div(int a, int b);
}
