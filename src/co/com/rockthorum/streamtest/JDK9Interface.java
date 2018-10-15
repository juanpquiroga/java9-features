package co.com.rockthorum.streamtest;

public interface JDK9Interface {
    void method1();
    String method2(String s);

    default void method3() {
        setup();
    }

    default void method4() {
        setup();
    }

    default void method5() {
        setupStatic();
    }

    private void setup() {
        System.out.println("Default behavior setup");
    }

    private static void setupStatic() {
        System.out.println("Default behavior static setup");
    }
}
