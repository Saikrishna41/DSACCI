package localinnerdemo;

import java.util.HashMap;
import java.util.Map;

public class LocalDemo {
    private String outerclassmember = "Info";
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void method1() {
        String s = "";
        class Printer {
            public void printInfo() {
                outerclassmember = "skskk";
                System.out.println(outerclassmember);
            }
        }
        Printer p = new Printer();
        p.printInfo();
    }

    public static void main(String[] args) {
        LocalDemo localDemo = new LocalDemo();
        localDemo.method1();
    }
}


