package com.jd

class Example_Method {

    static int X = 100;

    static void main(String[] args) {

        def exampleMethod = displayName();
        println(exampleMethod);

        println(sum(1, 10));

        // 方法参数支持默认值，但默认值只能放在参数列表的末尾，可以有带多个默认值的方法
        println(sum2(10));

        println(sum3(10));


        println(getX())
    }


    static int getX() {
        this.X = 2000000;
        return X;
    }

    static def displayName() {
        println("This is how methods work in groovy");
        println("This is an example of a simple method");

        // return "xxx";
        return new Example_Method();
    }

    static int sum(int a, int b) {
        int c = a + b;
        println(c);
        return c;
    }

    static def sum2(int a, int b = 5) {
        int c = a + b;
        //println(c);
        return c;
    }

    static def sum3(int a, int b = 5, int k = 5) {
        int c = a + b + k;
        //println(c);
        return c;
    }

}
