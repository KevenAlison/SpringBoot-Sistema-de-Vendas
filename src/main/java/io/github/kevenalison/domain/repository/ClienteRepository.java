package io.github.kevenalison.domain.repository;
import io.github.kevenalison.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
