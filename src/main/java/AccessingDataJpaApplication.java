import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new AddressBook());


            // fetch all customers
            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addB : repository.findAll()) {
                log.info(addB.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook addB = repository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(addB.toString());
            log.info("");

            // fetch customers by last name
            log.info("AddressBook found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }


}