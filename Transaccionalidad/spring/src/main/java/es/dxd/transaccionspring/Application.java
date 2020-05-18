package es.dxd.transaccionspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import es.dxd.transaccionspring.model.Balances;
import es.dxd.transaccionspring.repositories.BalancesRepository;

@SpringBootApplication
@EnableJpaRepositories
public class Application {

    @Autowired
    BalancesRepository balancesRepository;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initialData() {
        Balances julio = balancesRepository.findByName("Julio").get();
        julio.setBalance(julio.getBalance() + 1000);
        balancesRepository.save(julio);

        Balances juan = balancesRepository.findByName("Juans").orElseThrow();
        juan.setBalance(juan.getBalance() - 1000);
        balancesRepository.save(juan);
    }
}
