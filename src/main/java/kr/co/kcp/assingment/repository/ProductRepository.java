package kr.co.kcp.assingment.repository;

import kr.co.kcp.assingment.constant.Category;
import kr.co.kcp.assingment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(Category category);
}
