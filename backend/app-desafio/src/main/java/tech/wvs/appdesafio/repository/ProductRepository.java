package tech.wvs.appdesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.appdesafio.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
