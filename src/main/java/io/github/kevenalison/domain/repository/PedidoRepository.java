package io.github.kevenalison.domain.repository;

import io.github.kevenalison.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
