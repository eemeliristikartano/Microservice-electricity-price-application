package com.demo.pricesearchservice.service;

import com.demo.pricesearchservice.dto.PriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class PriceSearchService {

    @Value("${PRICE_SEARCH_API}")
    String API;

    HttpURLConnection connection = null;
    BufferedReader reader = null;
    InputStream inputStream = null;

    public ResponseEntity getPrice(String date, String hour) {
        try {
            connection = getConnection(date, hour);
            reader = getBufferedReader(connection);
            PriceDTO priceDTO = mapObject(reader);

            // Dividing the price to match the format of the second API.
            // From cent / kWh -> euro / kWh
            dividePriceBy100(priceDTO);

            // Rounding the price to match the format of the second API.
            roundPrice(priceDTO);

            return ResponseEntity.ok(priceDTO);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatusCode.valueOf(HttpStatus.SC_BAD_REQUEST));
        } finally {
            closeConnections(connection, reader, inputStream);
        }
    }

    private HttpURLConnection getConnection(String date, String hour) throws IOException {
        URL url = new URL(API + "?date=" + date + "&hour=" + hour);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    private BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        inputStream = connection.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private PriceDTO mapObject(BufferedReader reader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(reader, PriceDTO.class);
    }

    private void dividePriceBy100(PriceDTO priceDTO) {
        double currentPrice = priceDTO.getPrice();
        double dividedPrice = currentPrice / 100;
        priceDTO.setPrice(dividedPrice);
    }

    private void roundPrice(PriceDTO priceDTO) {
        double currentPrice = priceDTO.getPrice();
        double roundedPrice = Math.round(currentPrice * 10_000.0) / 10_000.0;
        priceDTO.setPrice(roundedPrice);
    }

    private void closeConnections(HttpURLConnection connection, BufferedReader reader, InputStream inputStream) {
        if (connection != null) connection.disconnect();
        try {
            if (reader != null) reader.close();
            if (inputStream != null ) inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
