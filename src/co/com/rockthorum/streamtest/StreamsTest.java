package co.com.rockthorum.streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        List<Integer> prueba1 = List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Prueba de take while  con stream de la lista");
        prueba1.stream().takeWhile(n->n<=5).forEach(System.out::println);

        System.out.println("Prueba de take while con stream directo");
        Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(n->n<=5).forEach(System.out::println);

        System.out.println("Prueba de drop while  con stream de la lista");
        prueba1.stream().dropWhile(n->n<=5).forEach(System.out::println);

        System.out.println("Prueba de drop while con stream directo");
        Stream.of(1,2,3,4,5,6,7,8,9,10).dropWhile(n->n<=5).forEach(System.out::println);

        System.out.println("Prueba de iterate java 8");
        Stream.iterate(1,x->x+1).limit(3).forEach(System.out::println);

        //System.out.println("Prueba de iterate java 8 con filter nunca termina" );
        //Stream.iterate(1,x->x+1).filter(x->x<=3).forEach(System.out::println);
        System.out.println("Prueba de iterable con java 9 indicandole hasNext");
        Stream.iterate(1,x->x<=3,x->x+1).forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("Frank");
        list.add("James");
        list.add(null);
        list.add("Tommy");

        System.out.println("Prueba de ofNullable");
        list.stream().flatMap(str->Stream.ofNullable(str)).forEach(System.out::println);

        System.out.println("Prueba de collected");
        //List<String> collected = list.stream().flatMap(str->Stream.ofNullable(str)).collect(Collectors.toList());
        List<String> collected = list.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());
        System.out.println(collected);

        System.out.println("Prueba de string");
        List<String> trees = List.of("Cherry","Oak","Pine","Spruce","Walnut","Willow");
        System.out.println("Take while with map");
        trees.stream().map(s->s.toLowerCase()).takeWhile(s->!s.startsWith("w")).forEach(System.out::println);
        System.out.println("Take while without map");
        trees.stream().takeWhile(s->!s.startsWith("W")).forEach(System.out::println);

        System.out.println("Drop while");
        trees.stream().map(s->s.toLowerCase()).dropWhile(s->!s.startsWith("w")).forEach(System.out::println);
    }
}
