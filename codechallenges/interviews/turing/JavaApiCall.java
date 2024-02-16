package codechallenges.interviews.turing;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class JavaApiCall {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    /*
     * Complete the 'findCountry' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING region
     *  2. STRING keyword
     * Base URL for copy/paste:
     * https://jsonmock.hackerrank.com/api/countries/search?region={region} &name={keyword}
     */
    public static ArrayList<String> findCountry(String region, String keyword) {
        try {
            String url = "https://jsonmock.hackerrank.com/api/countries/search?region=" + region + "&name=" + keyword;

            HttpClient httpClient = HttpClient.newHttpClient();

            // Create a request object
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response body
            System.out.println(response.body());

            // Parse the response body

            return new ArrayList<String>();
        } catch (Exception e) {
            System.out.println(e);

            return null;
        }
    }
}
