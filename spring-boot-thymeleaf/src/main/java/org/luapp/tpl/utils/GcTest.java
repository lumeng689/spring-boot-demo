package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2020/03/12
 **/
public class GcTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+PrintGCDateStamps
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation5 = new byte[4 * _1MB];
    }

    /**
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1  -XX:+PrintGCDateStamps
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB/4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }


    public static void main(String[] args) {
//        testAllocation();
        testTenuringThreshold();
    }
}
