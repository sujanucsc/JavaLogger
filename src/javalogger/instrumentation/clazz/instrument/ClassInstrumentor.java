package javalogger.instrumentation.clazz.instrument;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by IntelliJ IDEA.
 * User: sujan
 * Date: May 29, 2010
 * Time: 10:36:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClassInstrumentor {

    public static void instrument(String path) throws Exception{
        ClassPool cp = ClassPool.getDefault();
        cp.appendClassPath(path+"/out");
        CtClass sampleClass = cp.get("javalogger.sample.source.SampleClass");
        CtMethod[] methods = sampleClass.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            methods[i].insertBefore("System.out.println(\"Entering to :"+methods[i].getName()+"\");");
            methods[i].insertAfter("System.out.println(\"Exit from :"+methods[i].getName()+"\");");
        }
        sampleClass.writeFile(path+"/output");

    }

    public static void main(String args[]){
        try {
            instrument(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
