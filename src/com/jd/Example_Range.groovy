package com.jd

class Example_Range {

    static void main(String[] args) {

        def range = 1..5;
        println(range);
        println(range.get(0) + "--------" + range.get(4))

        // 范围循环
        for (i in range) {
            println "range:" + i;
        }
        for (def i in 3..5) {
            println "range:" + i;
        }

        // 数据遍历
        int[] array = [0, 1, 2, 3];
        for (int i in array) {
            println(i);
        }

        // for-in 语句也可用于循环访问Map
        def employee = ["Ken": 21, "John": 25, "Sally": 22];
        for (emp in employee) {
            println emp
        }

        // map 可以使用 for-in 进行遍历访问
        def map = new HashMap<>();
        map.put("xxx", 112323);
        map.put("yyy", 224455);
        for (m in map) {
            println m;
        }

        println "map.get(xxx)===========" + map.get("xxx")

        // 灵活的范围控制操作
        rangeX();
    }

    static void rangeX() {

        def tmp = 1..10;
        for (i in tmp) {
            println i;
        }

        tmp = 1..<5
        println tmp.getFrom() + "===========" + tmp.getTo();

        tmp = 10..1;
        for (i in tmp) {
            println i;
        }

        def array = tmp.subList(1, 5).toArray();
        println array;
    }


}
