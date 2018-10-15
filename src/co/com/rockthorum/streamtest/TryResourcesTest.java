package co.com.rockthorum.streamtest;

public class TryResourcesTest {
    public static void main(String[] args) {
        System.out.println("PRE JDK 7");
        System.out.println("------------");
        preJDK7(0);
        System.out.println("------------");
        preJDK7(1);
        System.out.println("------------");
        preJDK7(2);
        System.out.println("------------");
        preJDK7(3);
        System.out.println("------------");

        System.out.println("JDK 7");
        System.out.println("------------");
        jdk7(0);
        System.out.println("------------");
        jdk7(1);
        System.out.println("------------");
        jdk7(2);
        System.out.println("------------");
        jdk7(3);
        System.out.println("------------");

        System.out.println("JDK 7 Supressed");
        System.out.println("------------");
        jdk7Supressed(0);
        System.out.println("------------");
        jdk7Supressed(1);
        System.out.println("------------");
        jdk7Supressed(2);
        System.out.println("------------");
        jdk7Supressed(3);
        System.out.println("------------");

        System.out.println("JDK 9");
        System.out.println("------------");
        jdk9(0);
        System.out.println("------------");
        jdk9(1);
        System.out.println("------------");
        jdk9(2);
        System.out.println("------------");
        jdk9(3);
        System.out.println("------------");

        System.out.println("JDK 9 Multiple");
        System.out.println("------------");
        jdk9Multiple(0);
        System.out.println("------------");
        jdk9Multiple(1);
        System.out.println("------------");
        jdk9Multiple(2);
        System.out.println("------------");
        jdk9Multiple(3);
        System.out.println("------------");
    }

    public static void preJDK7(int resID ) {
        MyResource res = null;

        try {
            res = new MyResource( resID);
            res.process();
        } catch (Exception e) {
            System.out.println("Handling " + e.toString());
        } finally {
            try {
                if ( res != null ) {
                    res.close();
                }
            } catch (Exception ex) {
                System.out.println("Handling " + ex.toString());
            }
        }
    }

    public static void jdk7( int resID ) {
        try ( MyResource res = new MyResource(resID)) {
            res.process();
        } catch (Exception e ) {
            System.out.println("Handling " + e.toString());
        }
    }

    public static void jdk7Supressed( int resID ) {
        try ( MyResource res = new MyResource(resID)) {
            res.process();
        } catch (Exception e ) {
            System.out.println("Handling " + e.toString());
            int numSupressed = e.getSuppressed().length;
            for (int i = 0; i < numSupressed; i++) {
                System.out.println("Handling supressed " + e.getSuppressed()[i]);
            }
        }
    }

    public static void jdk9( int resID ) {
        MyResource res = new MyResource(resID);
        try (res) {
            res.process();
        } catch (Exception e) {
            System.out.println("Handling " + e.toString());
        }
    }

    public static void jdk9Multiple( int resID ) {
        MyResource res = new MyResource(resID);
        MyResource res2 = new MyResource(resID);

        try (res; res2; MyResource res3 = new MyResource(resID);) {
            res.process();
            res2.process();
            res3.process();
        } catch (Exception e) {
            System.out.println("Handling " + e.toString());
        }
    }
}
