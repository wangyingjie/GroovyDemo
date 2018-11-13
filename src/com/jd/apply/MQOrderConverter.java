package com.jd.apply;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>2018/11/13 17:21</p>
 *
 * @author wangyingjie1
 * @since V1.0
 */
public class MQOrderConverter {

    private static final Log errLog = LogFactory.getLog(MQOrderConverter.class);
    private static MQOrderConverter mQOrderConverter;
    private String path;
    private GroovyEngine engine;

    protected MQOrderConverter(String path) {
        this.path = path;
        this.load();
    }

    private void load() {
        try {
            this.engine = new GroovyEngine(this.path);
        } catch (Exception var2) {
            errLog.error("MQOrderConverter load error", var2);
            throw new RuntimeException(var2);
        }
    }

    public String convert(String mqText) {
        String result = null;
        if (!"".equals(mqText)) {
            Object[] args = new Object[]{mqText};
            result = (String)this.engine.invokeMethod("convert", args);
        }

        return result;
    }

    public static synchronized MQOrderConverter getInstance(String path) {
        return mQOrderConverter == null ? new MQOrderConverter(path) : mQOrderConverter;
    }
}
