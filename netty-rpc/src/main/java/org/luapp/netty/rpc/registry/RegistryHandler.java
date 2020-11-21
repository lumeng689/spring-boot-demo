package org.luapp.netty.rpc.registry;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.luapp.netty.rpc.protocol.InvokerProtocol;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 86150
 * @create: 2020/11/21
 **/
public class RegistryHandler extends ChannelInboundHandlerAdapter {

    public static ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>();

    private List<String> classNames = new ArrayList<>();

    public RegistryHandler() {
        scannerClass("org.luapp.netty.rpc.provider");
        doRegister();
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;

        if (registryMap.contains(request.getClassName())) {
            Object clazz = registryMap.get(request.getClassName());
            Method method = clazz.getClass().getMethod(request.getMethodName(), request.getParams());

            result = method.invoke(clazz, request.getValues());
        }

        ctx.write(result);
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));

        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scannerClass(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", "").trim());
            }
        }
    }

    private void doRegister() {
        if (classNames.size() == 0) {
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                registryMap.put(i.getName(), clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
