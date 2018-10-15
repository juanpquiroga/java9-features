package co.com.rockthorum.streamtest;

public class MyClass<T> {
    T data;

    public MyClass( T data ) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void processData(){
        System.out.println("Procesing data...");
    }
}
