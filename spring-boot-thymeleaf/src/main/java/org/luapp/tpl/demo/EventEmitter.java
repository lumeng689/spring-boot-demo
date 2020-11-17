package org.luapp.tpl.demo;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Event 注册类
 *
 * @author: 86150
 * @create: 2020/10/29
 **/
public class EventEmitter<T> {
    /**
     * 存放监听器， 按消息类型不同，存放在不同的list里面
     */
    private Map<EventType, List<Listener<T>>> eventCenter = new HashMap<>();
    /**
     * 存放一次性触发的监听器， 按消息类型不同，存放在不同的list里面
     */
    private Map<EventType, Stack<Listener<T>>> onceEventCenter = new HashMap<>();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    /**
     * 添加事件监听
     *
     * @param eventType
     * @param listener
     */
    public void on(EventType eventType, Listener<T> listener) {

        writeLock.lock();

        try {
            if (this.eventCenter.containsKey(eventType)) {
                List<Listener<T>> listeners = this.eventCenter.get(eventType);

                if (listeners == null) {
                    listeners = new LinkedList<>();
                    // 放回到map中
                    this.eventCenter.put(eventType, listeners);
                }

                listeners.add(listener);
            } else {
                List<Listener<T>> listeners = new LinkedList<>();
                listeners.add(listener);

                this.eventCenter.put(eventType, listeners);
            }
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 添加只执行一次的事件监听
     *
     * @param eventType
     * @param listener
     */
    public void once(EventType eventType, Listener listener) {

        writeLock.lock();

        try {
            if (this.onceEventCenter.containsKey(eventType)) {
                Stack<Listener<T>> listeners = this.onceEventCenter.get(eventType);

                if (listeners == null) {
                    listeners = new Stack<>();
                    // 放回到map中
                    this.onceEventCenter.put(eventType, listeners);
                }

                listeners.push(listener);
            } else {
                Stack<Listener<T>> listeners = new Stack<>();
                listeners.push(listener);

                this.onceEventCenter.put(eventType, listeners);
            }
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 触发事件
     *
     * @param eventType
     */
    public void send(EventType eventType, T... args) {

        readLock.tryLock();

        try {

            if (this.eventCenter.containsKey(eventType)) {
                List<Listener<T>> listeners = this.eventCenter.get(eventType);

                if (listeners != null && listeners.size() > 0) {
                    for (Listener<T> lis : listeners) {
                        lis.onEvent(args);
                    }
                }
            }

            if (this.onceEventCenter.containsKey(eventType)) {
                Stack<Listener<T>> listeners = this.onceEventCenter.get(eventType);

                if (listeners != null) {
                    while (!listeners.empty()) {
                        Listener<T> lis = listeners.pop();
                        lis.onEvent(args);
                    }
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 辅助打印参数
     *
     * @param args
     * @return
     */
    public static String join(Object... args) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Object a : args) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }

            sb.append(a);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        EventEmitter<Integer> eventEmitter = new EventEmitter<Integer>();

        eventEmitter.on(EventType.ADD, new Listener<Integer>() {
            @Override
            public void onEvent(Integer... args) {
                System.out.print("receive event add, args are: ");
                System.out.print(join(args));
                System.out.println();
            }
        });

        eventEmitter.on(EventType.MINUS, new Listener<Integer>() {
            @Override
            public void onEvent(Integer... args) {
                System.out.println("receive event minus");
            }
        });

        eventEmitter.once(EventType.ADD_ONCE, new Listener<Integer>() {
            @Override
            public void onEvent(Integer... args) {
                System.out.print("receive event add once, args are: ");
                System.out.print(join(args));
                System.out.println();
            }
        });

        eventEmitter.send(EventType.ADD, 1, 2, 3);
        eventEmitter.send(EventType.ADD, 1, 2, 3);
        eventEmitter.send(EventType.MINUS);
        eventEmitter.send(EventType.ADD_ONCE, 1, 2, 3);
        eventEmitter.send(EventType.ADD_ONCE, 1, 2, 3);
    }
}
