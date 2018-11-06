package com.jd

class Example_List {

    static void main(String[] args) {

        def list = [20, 11, 12, 13, 14];
        list.sort()
        for (int i = 0; i < list.size(); i++) {
            println list.get(i)
        }

        def newList = list.plus([1000, 2000])

        println newList

        println newList.pop()

        // 指定删除的对象或者是删除的位置
        // println newList.remove()

        def lst = [11, 12, 13, 14];
        println(lst.remove(2));
        println(lst);

        println(lst.pop());
        println(lst);
    }

}
