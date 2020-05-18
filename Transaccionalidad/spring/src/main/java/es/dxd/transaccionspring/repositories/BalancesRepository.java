package es.dxd.transaccionspring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.dxd.transaccionspring.model.Balances;


@Repository
public interface BalancesRepository extends CrudRepository<Balances, Integer> {
    Optional<Balances> findByName(String name);
}
