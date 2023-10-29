package br.gabriel.ferreira.strproducer.application.service;

import br.gabriel.ferreira.strproducer.application.interfaces.IStringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService implements IStringProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message);
    }
}


