package com.jd

import org.apache.bsf.BSFManager

/**
 *
 * <p>2018/11/14 13:46</p>
 * @author wangyingjie1
 * @since V1.0
 */
class Example_BSFManager {

    static void main(String[] args) {
        eval();
        call();
        load();
    }

    private static void eval() {
        String myScript = "println('Hello World')\n  return [1, 2, 3]";
        BSFManager manager = new BSFManager();
        List answer = (List) manager.eval("groovy", "myScript.groovy", 0, 0, myScript);
        // assertEquals(3, answer.size());
        println(answer.size())
    }

    static def call() {
        BSFManager manager = new BSFManager();
        Vector<String> ignoreParamNames = null;
        Vector<Integer> args = new Vector<Integer>();
        args.add(2);
        args.add(5);
        args.add(1);
        Integer actual = (Integer) manager.apply("groovy", "applyTest", 0, 0,
                "def summer = { a, b, c -> a * 100 + b * 10 + c }", ignoreParamNames, args);
        println(actual.intValue());
    }

    static def load() {
        def gcl = new GroovyClassLoader()                                                                                                       // <1>
        def clazz = gcl.parseClass('class Foo { void doIt() { println "ok" } }')                                // <2>
        assert clazz.name == 'Foo'                                                                              // <3>
        def o = clazz.newInstance()                                                                             // <4>
        o.doIt()
    }

}
