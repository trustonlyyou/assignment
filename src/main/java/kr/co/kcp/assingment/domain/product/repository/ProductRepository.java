package kr.co.kcp.assingment.domain.product.repository;

import kr.co.kcp.assingment.common.constant.Category;
import kr.co.kcp.assingment.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(Category category);
}
