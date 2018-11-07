package com.jd

class Example_Interceptable {

    static void main(String[] args) {
        Student2 mst = new Student2();
        // mst.Name = "Joe";
        // mst.ID = 1;
        //
        // println(mst.Name);
        // println(mst.ID);

        mst.metaClass.setAttribute(mst, 'name', 'Mark')

        println(mst.getName());
    }
}

// 未实现接口的所有方法
class Student2 implements GroovyInterceptable {

    //protected dynamicProps = [:]

    private String name = "Joe";

    // void setProperty(String pName, val) {
    //     dynamicProps[pName] = val
    // }
    //
    // def getProperty(String pName) {
    //     dynamicProps[pName]
    // }

    def invokeMethod(String name, Object args) {
        return "called invokeMethod $name $args"
    }

    // String getName() {
    //     return name
    // }
}