package co.com.rockthorum.streamtest;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientTest {

    public static void main(String[] args) {
        try {
            String url = "http://www.example.com";
            callGetURLSync(url);
            callPostURLSync(url);
            callGetURLAsync(url);
        } catch( Exception e) {
            e.printStackTrace();
        }
    }

    private static void callGetURLAsync(String url) throws URISyntaxException, java.io.IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI(url)).GET().build();
        CompletableFuture<HttpResponse<String>> compFuture = client.sendAsync(request,HttpResponse.BodyHandler.asString());

        System.out.println("Se realizó llamado async");
        while ( !compFuture.isDone()) {
            System.out.println("Procesar temporalmente");
        }
        System.out.println("Llamado async se realizó");
        processResponse(compFuture.get());
    }

    private static void callPostURLSync(String url) throws URISyntaxException, java.io.IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(new URI(url))
                .headers("Foo","Foo-val","Bar","Bar-val")
                .POST(HttpRequest.BodyPublisher.fromString("This is the string"))
                .build();
        HttpResponse response = client.send(request,HttpResponse.BodyHandler.asFile(Paths.get("FileXXXX.txt")));
        processResponse(response);
    }

    private static void callGetURLSync(String url) throws URISyntaxException, java.io.IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI(url)).GET().build();
        HttpResponse response = client.send(request,HttpResponse.BodyHandler.asString());
        processResponse(response);
    }

    private static void processResponse(HttpResponse response) {
        System.out.println(response.statusCode() + " " + response.body());
        HttpHeaders headers = response.headers();
        Map<String, List<String>> map = headers.map();
        map.forEach((k,v)-> System.out.println(k + ":" + v));
    }
}
