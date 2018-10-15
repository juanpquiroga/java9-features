package co.com.rockthorum.streamtest;

import java.util.List;

public class SafeVarArgsTest {

    public static int calculateSum(int... args){
        int sum =0;
        for (int i = 0; i < args.length; i++) {
            sum+=args[i];
        }
        return sum;
    }

    public static <T> void buildList(List<T> list, T... args ) {
        for (T item:args) {
            list.add(item);
        }
    }

    @SafeVarargs
    public static <T> T[] unsafe(T... args ){
        System.out.println(args);
        return args;
    }

    public static <T> T[] callUnsafe(T t1, T t2) {
        return unsafe(t1,t2);
    }


    public static void main(String[] args) {
        System.out.println(calculateSum(1,2,3));
        callUnsafe(1,2);
    }
}
