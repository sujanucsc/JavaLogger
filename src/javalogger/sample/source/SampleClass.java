package javalogger.sample.source;

/**
 * Created by IntelliJ IDEA.
 * User: sujan
 * Date: May 29, 2010
 * Time: 10:32:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class SampleClass {

    public static void main(String args[]){
        System.out.println(add(5,8));
        System.out.println(minus(8,5));
    }

    private static int add(int i, int j){
        return i+j;
    }

    private static int minus(int i, int j){
        return i-j;
    }
}
