package com.jd.pojo


class Student implements Person {

    @Override
    void run() {
        println("eat fast****************");
    }

    @Override
    void eat(def food) {
        println("eat =========" + food);
    }

    static void main(String[] args) {
        Person person = new Student();
        person.eat(" fish ");
        person.run();
    }

}
