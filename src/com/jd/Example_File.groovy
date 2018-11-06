package com.jd

class Example_File {

    static void main(String[] agrs) {

        File file = new File("d:\\README.md")
        // 按行读取文本文件
        file.eachLine {
            line ->
                println(line);
                // println "line : $line";
        }

        File file2 = new File("d:\\README.md")
        // 按行读取文本文件
        file2.eachLine {
            line ->
                // println(line);
                println "line : $line";
        }

        println("file.text===========>" + file2.text)

        // 写文件
        File writerFile = new File('D:/', 'Example.txt');
        writerFile.withWriter('utf-8') {
            writer -> writer.writeLine 'Hello World'
        }

        println "The file ${writerFile.absolutePath} has ${writerFile.length()} bytes"

        println "the file is file ${writerFile.isFile()}" + ", the file is not Directory ${writerFile.isDirectory()}"

        // 文件的copy
        def src = new File('D:/Example.txt');
        def dst = new File("D:/Example1.txt");
        dst << src.text;

        def rootFiles = new File("canal").listRoots()
        rootFiles.each {
            file3 -> println file3.absolutePath
        }

        new File("D:/canal").eachFile() {
            file4->println file4.getAbsolutePath()
        }

        new File("D:/canal").eachFileRecurse() {
            file5 -> println file5.getAbsolutePath()
        }

    }
}
