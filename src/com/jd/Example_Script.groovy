
/**
 *
 * <p>2018/11/14 10:49</p>
 * @author wangyingjie1
 * @since V1.0
 */
println "In Script2"
shell = new GroovyShell()
shell.evaluate(new File('Script1.groovy'))

// or simply
evaluate(new File('Script1.groovy'))