package com.semicolon.africa.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import static com.semicolon.africa.model.TicketType.VIP;
import static org.assertj.core.api.Assertions.assertThat;
import java.net.http.HttpRequest;

@SpringBootTest
class TicketsTest {
    @Autowired
    private Tickets tickets;
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    void findTicketByEventAndTicketType() {
        assertThat(tickets.findTicketByEventAndTicketType(1L, VIP)
       .get().getEvent().getEventTitle()).isEqualTo("wedding");
    }


    public static void pay() {
                try {
                    HttpURLConnection connection = getUrlConnection();

                    // Read the response
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        String responseLine;
                        StringBuilder response = new StringBuilder();
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        System.out.println("Response from Paystack API:\n" + response.toString());
                    }

                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    private static HttpURLConnection getUrlConnection() throws IOException {
        String url = "https://api.paystack.co/transaction/initialize";
        String secretKey = "sk_test_4b64e1d47b4d632565d13d4f1237488775e4c430"; // Replace with your actual secret key
        // Create the JSON payload
        String payload = "{ \"email\": \"customer@email.com\", \"amount\": \"200000000\" }";
        URL apiUrl = new URL(url);
        return getHttpURLConnection(apiUrl, secretKey, payload);
    }

    private static HttpURLConnection getHttpURLConnection(URL apiUrl, String secretKey, String payload) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + secretKey);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        // Send the payload
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        return connection;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
       pay();
//        connect("d9n9lhi1zw");
    }

    public static void connect(String reference) throws IOException, InterruptedException {
        String url = "https://api.paystack.co/transaction/verify/"+reference;
        String authorization = "Bearer sk_test_4b64e1d47b4d632565d13d4f1237488775e4c430";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", authorization)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}

