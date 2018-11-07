package com.jd

import groovy.text.SimpleTemplateEngine
import groovy.text.StreamingTemplateEngine
import groovy.text.XmlTemplateEngine

class Example_Template {

    static void main(String[] args) {
        def name = "Groovy"
        println "This Tutorial is about ${name}"

        // map 数据结构
        def binding = ["TutorialName": "Groovy", "Topic": "Templates"]

        // 只能使用单引号 否则：${TutorialName}  ${Topic} 编译出错
        def text = 'This Tutorial focuses on ${TutorialName}. In this tutorial you will learn about ${Topic}'
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(text).make(binding)

        println template

        templateFile();
        streamingTemplateEngine()
        xmlTemplateEngine()
    }

    static void templateFile() {
        File file = new File("F:\\workspace_git_2018\\GroovyDemo\\src\\com\\jd\\template");
        def binding = ['name': 'Joe', 'id': 1, 'subject': 'Physics']

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(file)
        def writable = template.make(binding)

        println writable
    }


    static void streamingTemplateEngine() {
        def text = '''This Tutorial is <% out.print TutorialName %> The Topic name is ${TopicName}'''
        def template = new StreamingTemplateEngine().createTemplate(text)

        def binding = [TutorialName: "Groovy", TopicName: "Templates",]
        String response = template.make(binding)
        println(response)
    }

    static void xmlTemplateEngine() {
        def binding = [StudentName: 'Joe', id: 1, subject: 'Physics']
        def engine = new XmlTemplateEngine()

        def text = '''
                   <document xmlns:gsp='http://groovy.codehaus.org/2005/gsp'>
                      <Student>
                         <name>${StudentName}</name>
                         <ID>${id}</ID>
                         <subject>${subject}</subject>
                      </Student>
                   </document> 
                '''

        def template = engine.createTemplate(text).make(binding)
        println template
    }


}
