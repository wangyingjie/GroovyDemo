package com.jd.pojo


class Student implements Person {

    private int id;

    private def name;

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

        person.setProperty("id", 10000)
        person.setProperty("name", "zhangsan")

        // 对象不能直接加字符串
        println person + ""
        println person
        println person.getProperty("id")

        person.eat(" fish ");
        person.run();
    }

    @Override
    String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    def getName() {
        return name
    }

    void setName(name) {
        this.name = name
    }
}
