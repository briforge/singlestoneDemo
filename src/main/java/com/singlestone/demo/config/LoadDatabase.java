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
        harry.getName().setMiddle("James");
        harry.setEmail("harry.potter@gryffindor.com");
        Address address = new Address();
        address.setStreet("4 Privet Drive");
        address.setCity("Surrey");
        address.setState("IN");
        address.setZip("46256");
        harry.setAddress(address);
        Phone phone = new Phone("317-867-5309", Phone.PhoneType.home);
        harry.setPhone(phone);

        Contact james = new Contact("James", "Potter");
        Phone phoneJames = new Phone("123-555-1212", Phone.PhoneType.home);
        james.setPhone(phoneJames);

        Contact lily = new Contact("Lily", "Potter");
        Phone phoneLilly = new Phone("123-555-1212", Phone.PhoneType.home);
        lily.setPhone(phoneLilly);

        Contact hermione = new Contact("Hermione", "Granger");

        Contact ron = new Contact("Ron", "Weasley");
        Phone phoneRon = new Phone("317-123-4567", Phone.PhoneType.mobile);
        ron.setPhone(phoneRon);

        Contact arthur = new Contact("Arthur", "Weasley");
        Phone phoneBurrow = new Phone("654-777-4444", Phone.PhoneType.home);
        arthur.setPhone(phoneBurrow);

        Contact molly = new Contact("Molly", "Weasley");
        molly.setPhone(phoneBurrow);

        return args -> {
            log.info("PreLoading " + repo.save(harry));
            log.info("PreLoading " + repo.save(james));
            log.info("PreLoading " + repo.save(lily));
            log.info("PreLoading " + repo.save(hermione));
            log.info("PreLoading " + repo.save(ron));
            log.info("PreLoading " + repo.save(arthur));
            log.info("PreLoading " + repo.save(molly));
        };

    }
}
