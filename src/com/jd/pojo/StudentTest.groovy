package com.jd.pojo

class StudentTest extends GroovyTestCase {

    void testDisplay() {
        def stud = new Student(id: 1000, name: 'zhangsan')
        def expected = 'zhangsan'
        assertToString(stud.getName(), expected)
    }



}
