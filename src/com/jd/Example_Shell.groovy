package com.jd

class Example_Shell {

    static void main(String[] args) {

        println "In Script3"

        Binding binding1 = new Binding()
        binding1.setProperty('name', 'Venkat')
        GroovyShell shell = new GroovyShell(binding1)
        shell.evaluate(new File('Script1a.groovy'))

        Binding binding2 = new Binding()
        binding2.setProperty('name', 'Dan')
        shell.binding = binding2
        shell.evaluate(new File('Script1a.groovy'))

        def join = ['Groovy', 'Rocks!'].join(' ')
        println("join==========" + join)
    }

}
