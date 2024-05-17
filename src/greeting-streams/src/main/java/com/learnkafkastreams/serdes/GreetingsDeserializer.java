package com.learnkafkastreams.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafkastreams.domain.Greeting;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class GreetingsDeserializer implements Deserializer<Greeting> {

    private ObjectMapper objectMapper;

    public GreetingsDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Greeting deserialize(String topic, byte[] data) {

        try{
            return objectMapper.readValue(data, Greeting.class);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}
