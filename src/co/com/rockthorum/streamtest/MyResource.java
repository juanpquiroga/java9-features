package co.com.rockthorum.streamtest;

public class MyResource implements AutoCloseable {
    private int id;

    public MyResource(int id) {
        this.id = id;
        System.out.println("creating resource " + id);
    }

    public void process() throws Exception {
        System.out.println("Processing resource " + id );
        if ( id == 1 || id == 3 ) {
            throw new Exception("Exception in process");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource " + id);
        if ( id == 2 || id == 3 ) {
            throw new Exception("Exception in close");
        }
    }
}
