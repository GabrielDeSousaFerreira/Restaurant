package br.com.gabriel.restaurante.repositories;

import br.com.gabriel.restaurante.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
