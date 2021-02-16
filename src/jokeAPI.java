import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;
// You are only able to use the org.json library after you've installed it.
import org.json.*;

public class jokeAPI {

    public static void getRandomJoke(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://joke3.p.rapidapi.com/v1/joke"))
                    .header("x-rapidapi-key", "1fec78eec2msh82a9b17b63b9475p18f46djsn9c7f0bc5b62b")
                    .header("x-rapidapi-host", "joke3.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            // Parse that object into a usable Java JSON object.
            JSONObject obj = new JSONObject(response.body());
            // Print out the movie name.
            String joke = obj.getString("content");
            System.out.println("The Joke: " + joke);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
