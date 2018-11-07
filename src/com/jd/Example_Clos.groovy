package com.jd

// groovy 的闭包
class Example_Clos {

    static void main(String[] args) {
        def clos = { println "Hello World" };
        clos.call();


        def clos2 = { param -> println "Hello ${param}" };
        clos2.call("World");

        // it 是groovy的保留关键字
        def clos3 = { println "Hello ${it}" };
        clos3.call("World");

        def str1 = "Hello";
        // 引用变量
        def clos4 = { param -> println "${str1} ${param}" }
        clos4.call("World");

        // We are now changing the value of the String str1 which is referenced in the closure
        str1 = "Welcome";
        clos4.call("World");


        def clos5 = { param -> println "${str1} ${param}" }
        clos5.call("World");

        // We are now changing the value of the String str1 which is referenced in the closure
        str1 = "Welcome";
        clos5.call("World");

        // Passing our closure to a method
        Example_Clos.display(clos5);

        list();
        map();

    }

    def static display(clo) {
        // This time the $param parameter gets replaced by the string "Inner"
        clo.call("Inner");
    }

    static void list() {
        def list = [11, 12, 13, 14];
        list.each { println it + "===== it 保留字 ====" + "$it" }

        def lst = [1, 2, 3, 4];
        lst.each { println it }
        println("The list will only display those numbers which are divisible by 2")
        lst.each { num -> if (num % 2 == 0) println num }

        def value;
        value = lst.findAll { element -> element > 2 }
        value.each { println "find ele----->" + it }

        def find = lst.find { ele -> ele == 4 }
        println find + " find it "

    }

    static void map() {
        def mp = ["TopicName": "Maps", "TopicDescription": "Methods in Maps"]
        mp.each { println it }
        mp.each { println "${it.key} maps to: ${it.value}" }
    }


}
