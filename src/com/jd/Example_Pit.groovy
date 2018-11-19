package com.jd

import org.codehaus.groovy.runtime.InvokerHelper

/**
 * todo groovy 与 java 集成的坑
 * <p>2018/11/19 13:45</p>
 * @author wangyingjie1
 * @since V1.0
 */
class Example_Pit {

    public static void main(String[] args) {

        // GroovyClassLoader

        while (true) {
            Binding binding = new Binding();
            GroovyShell shell = new GroovyShell(binding);
            def file = new File('Script2.groovy');
            binding.setVariable("x", 10);
            binding.setVariable("language", "Groovy");

            // Object value = shell.evaluate("return x*2");//反复执行这段groovy脚本
            // System.out.println(value);

            def source = new GroovyCodeSource(file, "UTF-8");
            source.setCachable(true);// 允许脚本缓存
            // Object value = shell.evaluate(source);

            def loader = new GroovyClassLoader();
            def clazz = loader.parseClass(source, true);
            def script = InvokerHelper.createScript(clazz, binding);

            Object value = script.run();

            System.out.println(value);
        }
    }

}
