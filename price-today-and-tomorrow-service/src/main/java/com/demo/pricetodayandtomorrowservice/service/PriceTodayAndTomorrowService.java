package com.demo.pricetodayandtomorrowservice.service;

import com.demo.pricetodayandtomorrowservice.dto.PriceDTO;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceTodayAndTomorrowService {

    @Value("${PRICE_TODAY_AND_TOMORROW_API}")
    String API;

    final String ENDPOINT = "TodayAndDayForward";

    HttpURLConnection connection = null;
    BufferedReader reader = null;
    InputStream inputStream = null;

    public ResponseEntity priceTodayAndTomorrow() {
        try {
            connection = getConnection();
            reader = getBufferedReader(connection);
            //PricesDTO pricesDTO = mapObject(reader);
            JsonNode jsonNode = new ObjectMapper().readTree(reader);
            List<PriceDTO> prices = mapPrices(jsonNode);

            return ResponseEntity.ok(prices);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatusCode.valueOf(HttpStatus.SC_BAD_REQUEST));
        } finally {
            closeConnections(connection, reader, inputStream);
        }

    }

    private HttpURLConnection getConnection() throws IOException {
        URL url = new URL(API + ENDPOINT);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    private BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        inputStream = connection.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private List<PriceDTO> mapPrices(JsonNode jsonNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<PriceDTO> prices = new ArrayList<>();

        if (jsonNode.isArray()) {
            for (JsonNode priceNode : jsonNode) {
                PriceDTO price = objectMapper.convertValue(priceNode, PriceDTO.class);
                price.setHour(price.getDateTime().substring(11,13 ));
                prices.add(price);
            }
        }

        return prices;
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
