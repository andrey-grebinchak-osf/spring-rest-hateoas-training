package payroll;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository empRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + empRepository.save(new Employee("Bilbo" ,"Baggins", "burglar")));
            log.info("Preloading " + empRepository.save(new Employee("Frodo",  "Baggins", "thief")));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}