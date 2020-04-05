package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2020/03/13
 **/
public class HeapOOM {
    static class OOMObject {

    }

    /**
     *  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while(true) {
            list.add(new OOMObject());
        }
    }
}
