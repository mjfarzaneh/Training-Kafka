package com.training.kafka.producer;

import com.training.kafka.domain.LibraryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public LibraryEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLibraryEvent(LibraryEvent libraryEvent) {

        String value = libraryEvent.toString();

        kafkaTemplate.send("kafka-test-topic", value);
//        kafkaTemplate.send("test-events", value);

    }

}
