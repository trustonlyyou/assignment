package kr.co.kcp.assingment.repository;

import kr.co.kcp.assingment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
