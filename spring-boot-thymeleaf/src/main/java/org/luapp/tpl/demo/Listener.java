package org.luapp.tpl.demo;

/**
 * 监听者接口
 *
 * @author: 86150
 * @create: 2020/10/29
 **/
public interface Listener<T> {

    /**
     * 触发事件后回调改接口
     *
     * @param args
     */
    void onEvent(T... args);
}
