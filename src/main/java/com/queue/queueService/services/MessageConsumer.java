package com.queue.queueService.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
@Service
public class MessageConsumer {
    @RabbitListener(queues = "emailData")

    public void receiveAndSendToAnotherApp(String requestData) throws IOException {

        System.out.println("Received data"+ requestData);

        senDataToAnotherApp(requestData);
    }

    private static void senDataToAnotherApp(String data) {

        try {
            // Specify the URL you want to send the POST request to
            String url = "http://localhost:8888";

            // Create a URL object with the specified URL
            URL obj = new URL(url);

            // Open a connection to the URL
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Set the HTTP Method to POST
            con.setRequestMethod("POST");

            // Add request headers (optional)
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer your_access_token");

            // Enable input/output streams for reading/writing data
            con.setDoOutput(true);

            // Create the POST data to send
            String postData = "param1=value1&param2=value2";
            byte[] postDataBytes = postData.getBytes();

            // Write the POST data to the output stream
            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.write(postDataBytes);
            }

            // Get the response code
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Print the response
                System.out.println("Response: " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

