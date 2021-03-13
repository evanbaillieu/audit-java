package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

/**
 * @author Snowsdy
 */
@Service
@RestController
public class BeerService implements Serializable {

    @Autowired
    RestTemplate restTemplate;
    public static final String template = "Bière %s";
    public static final String springMessage = "Spring Service";

    public BeerService() {
    }

    public String sayHello() {
        return springMessage;
    }

    @GetMapping("/message")
    public Beer getBeer(@RequestParam(value = "name", defaultValue = "beer") String name,
                        @RequestParam(value = "price", defaultValue = "1.0") float price,
                        @RequestParam(value = "available", defaultValue = "false") boolean available){
        return new Beer(String.format(template, name), price, available);
    }

    @GetMapping("/end")
    public void end() {
        System.exit(0);
    }
}
