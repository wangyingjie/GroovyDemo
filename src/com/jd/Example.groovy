package com.jd

import groovy.xml.MarkupBuilder

class Example {

    def employeename = 1;
    def student1 = 'xxxxxx';
    def student_name = "nihao ${student1}";

    static void main(String[] args) {

        System.out.println("xxxxxxxx");
        // Using a simple println statement to print output to the console

        def builder = new MarkupBuilder();

        def x = 5;
        //assert x != 5;

        printf getName() + " Hello world" + " " + "\n";

        // def example = new Example();
        Example example = new Example();
        def student1 = example.getStudent1();

        println student1 + "============" + example.getStudent_name();
    }

    static String getName() {
        def x1 = 12
        def x2 = 1.45
        def x3 = 'a'
        def x4 = "aa"

        return "zhangsan"
    }


}
