package com.jd.apply;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

/**
 * <p>2018/11/13 17:23</p>
 *
 * @author wangyingjie1
 * @since V1.0
 */
public class GroovyEngine {

    private static final Log errLog = LogFactory.getLog(GroovyEngine.class);
    private GroovyObject instance = null;

    public GroovyEngine(String script) {
        this.createInstance(script);
    }

    private void createInstance(String script) {
        try {
            ClassLoader parent = GroovyEngine.class.getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(parent);

            File file = new File("F:\\workspace_git_2018\\GroovyDemo\\src\\com\\jd\\apply\\MQOrderConverter.groovy");
            Class groovyClass = loader.parseClass(file);

            //Class groovyClass = loader.parseClass(script);

            this.instance = (GroovyObject)groovyClass.newInstance();

        } catch (Exception var5) {
            errLog.error("Groovy script is error", var5);
            throw new RuntimeException(var5);
        }
    }

    // public GroovyEngine(InputStream script) {
    //     this.createInstance(script);
    // }
    //
    // private void createInstance(InputStream script) {
    //     try {
    //         ClassLoader parent = GroovyEngine.class.getClassLoader();
    //         GroovyClassLoader loader = new GroovyClassLoader(parent);
    //         Class groovyClass = loader.parseClass(script);
    //         this.instance = (GroovyObject)groovyClass.newInstance();
    //         script.close();
    //         script = null;
    //     } catch (Exception var5) {
    //         errLog.error("Groovy script is error", var5);
    //         throw new RuntimeException(var5);
    //     }
    // }

    public Object invokeMethod(String methodName, Object[] args) {
        return this.instance.invokeMethod(methodName, args);
    }

    public Object getInstance() {
        return this.instance;
    }
}
