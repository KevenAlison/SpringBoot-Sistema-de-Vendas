package io.github.kevenalison.domain.repository;

import io.github.kevenalison.domain.entity.Cliente;
import io.github.kevenalison.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
