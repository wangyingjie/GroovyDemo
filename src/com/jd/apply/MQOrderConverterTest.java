package com.jd.apply;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>2018/11/12 18:17</p>
 *
 * @author wangyingjie1
 * @since V1.0
 */
public class MQOrderConverterTest {

    @Test
    public void testConverter() throws Exception {


        String orderXml = readFileByLines("F:\\workspace_git_2018\\GroovyDemo\\src\\com\\jd\\apply\\erp补单消息.txt");

        // MQOrderConverter converter = new MQOrderConverter("MQOrderConverter.groovy");
        MQOrderConverter orderConverter = MQOrderConverter.getInstance("MQOrderConverter.groovy");

        String convert = orderConverter.convert(orderXml);

        System.out.println(convert);

    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
                line++;
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }


}
