package com.example.Lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AddressBookJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AddressBookJpaApplication.class);
//    @Autowired
//    private BuddyInfoRepository bir;

    public static void main(String[] args) {
        SpringApplication.run(AddressBookJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save atleast one addressbook
            // repository.save(new AddressBook());
            repository.save(new BuddyInfo("Tami", "ottawa", "613"));
            repository.save(new BuddyInfo("Jin", "ottawa", "647"));
            repository.save(new BuddyInfo("john", "ottawa", "123"));



            // fetch all addressbook
            log.info("BuddyInfo found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo ab : repository.findAll()) {
                log.info(ab.toString());
            }
            log.info("");


            // fetch an individual addressbook by ID
            log.info("AddressBook found with findByName():");
            log.info("--------------------------------");
            repository.findByName("Tami").forEach(tami ->{
                log.info(tami.toString());
            });
            log.info("");

        };
    }

}
