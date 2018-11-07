package com.jd

class Example_Trait {

    static void main(String[] args) {
        //Student st = new Student();
        Marks st = new Student();
        st.studentID = 1;

        st.displayMarks(st.studentID);
        st.displayTotal();
        st.displayMarksTotal2()
    }

}

// todo 特征 不支持抽象的方法
trait Marks {
    void displayMarks(def id = 200) {
        println("Marks1" + "=====" + id);
    }

    // void play();
}

trait Total {

    void displayTotal(def id = 100) {
        println("Total" + "=====" + id);
    }
}

trait Total2 extends Marks {

    void displayMarksTotal2() {
        println("Total");
    }
}

// 实现类可以实现多个特征  实现特征使用关键字 implements  解决多重继承的问题
class Student implements Marks, Total, Total2 {

    int studentID
}