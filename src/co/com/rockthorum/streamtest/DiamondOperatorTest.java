package co.com.rockthorum.streamtest;

public class DiamondOperatorTest {
    public static void main(String[] args) {
        MyClass<String> c1 = new MyClass<String>("Frank") {
            @Override
            public void processData() {
                System.out.println("Procesing data override... " + getData() );
            }
        };
        c1.processData();

        MyClass<String> c2 = new MyClass<>("James") {
            @Override
            public void processData() {
                System.out.println("Procesing data override... " + getData() );
            }
        };
        c2.processData();

        MyClass<Integer> c3 = new MyClass<>(2){
            @Override
            public void processData() {
                System.out.println("Procesing data override... " + getData() );
            }
        };
        c3.processData();
    }
}
