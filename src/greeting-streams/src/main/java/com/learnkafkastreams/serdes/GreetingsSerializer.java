package com.learnkafkastreams.serdes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafkastreams.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class GreetingsSerializer implements Serializer<Greeting> {

    private ObjectMapper objectMapper;

    public GreetingsSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public byte[] serialize(String topic, Greeting data) {

        try {
            return objectMapper.writeValueAsBytes(data);
        }
        catch(JsonProcessingException e) {
            throw  new RuntimeException(e);
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }


    }
}
