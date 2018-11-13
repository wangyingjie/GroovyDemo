package com.jd

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class Example_Json {

    private static JsonSlurper jsonSlurper = new JsonSlurper();

    static void main(String[] args) {
        Object lst = jsonSlurper.parseText('{ "List": [2, 3, 4, 5] }')
        lst.each { println it }

        def obj = jsonSlurper.parseText ''' {"Integer": 12, "fraction": 12.55, "double": 12e13}'''

        println(obj.Integer);
        println(obj.fraction);
        println(obj.double);

        def output = JsonOutput.toJson([name: 'John', ID: 1])
        println(output);

        def outputTeacher = JsonOutput.toJson([new Teacher(name: 'John', ID: 1),
                                               new Teacher(name: 'Mark', ID: 2)])
        println(outputTeacher);
    }
}

class Teacher {
    String name
    int ID;
}
