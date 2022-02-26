package com.singlestone.demo.config;

import com.singlestone.demo.model.Address;
import com.singlestone.demo.model.Contact;
import com.singlestone.demo.model.Phone;
import com.singlestone.demo.repos.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactRepository repo) {
        Contact harry = new Contact("Harry", "Potter");
        harry.setEmail("harry.potter@gryffindor.com");
        Address address = new Address();
        address.setStreet("4 Privet Drive");
        address.setCity("Surrey");
        address.setState("IN");
        address.setZip("46256");
        harry.setAddress(address);
        Phone phone = new Phone("317-867-5309", Phone.PhoneType.home);
        harry.setPhone(phone);

        Contact hermione = new Contact("Hermione", "Granger");

        Contact ron = new Contact("Ron", "Weasley");
        Phone phoneRon = new Phone("317-123-4567", Phone.PhoneType.mobile);
        ron.setPhone(phoneRon);

        return args -> {
            log.info("PreLoading " + repo.save(harry));
            log.info("PreLoading " + repo.save(hermione));
            log.info("PreLoading " + repo.save(ron));
        };

    }
}
