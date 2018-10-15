package co.com.rockthorum.streamtest;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryCollectionsTest {
    public static void main(String[] args) {
        List<String> peopleList = List.of("Juan","Carlos","Roberto");
        System.out.println(peopleList.toString());

        Set<String> peopleSet = Set.of("Juan","Carlos","Roberto");
        System.out.println(peopleSet.toString());

        Map<Integer,String> peopleMap = Map.of(1,"Juan", 2, "Carlos", 3, "Roberto");
        System.out.println(peopleMap.entrySet().toString());

        // Otra prueba de map
        System.out.println("Map con for each");
        peopleMap.forEach((k,v)->System.out.printf("Key: %d, Value:%s\n",k,v));

        try {
            List.of("juan",null);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            peopleList.add("Hola");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }

        try {
            Set.of("juan","juan");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        try {
            Map.of(1,"juan",1, "roberto");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        List<Person> chefs = List.of(
                new Person("Carlos",10),
                new Person("Roberto", 3),
                new Person("Diego",8)
        );
        System.out.println(chefs);

        List<Person> managers = List.of(
                new Person("Ingrid",6),
                new Person("Diana", 9)
        );
        System.out.println(managers);

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("chefs.ser"))) {
            ous.writeObject(chefs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chefs.ser"))) {
            List<Person> chefsFile = (List<Person>)ois.readObject();
            System.out.println(chefsFile.toString());
            // no se puede adicionar
            chefsFile.add(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
