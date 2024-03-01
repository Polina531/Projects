import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStuff {

    private static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/todos/1";

public static void main(String[] args) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .header("accept", "application/json")
            .uri(URI.create(POSTS_API_URL))
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
    System.out.println(response.body());
    
}
}