package br.gabriel.ferreira.strproducer.apresentation;

import br.gabriel.ferreira.strproducer.application.interfaces.IStringProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/str-producer")
public class StringProducerController {

    private final IStringProducerService _stringProducerService;

    public StringProducerController(IStringProducerService stringProducerService) {
        _stringProducerService = stringProducerService;
    }

    @PostMapping
    public ResponseEntity<?> sendMenssage(@RequestBody String message){
        _stringProducerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
