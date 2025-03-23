package kr.co.kcp.assingment.repository;

import kr.co.kcp.assingment.constant.Category;
import kr.co.kcp.assingment.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상풍 저장 테스트")
    public void saveProduct() throws Exception {
        //given
        Product product = Product.builder()
                .product_name("PLAC Jean")
                .product_price(new BigDecimal(100000))
                .product_inventory(10)
                .category(Category.BOTTOM)
                .build();

        //when
        Product createProduct = productRepository.save(product);

        //then
        assertNotNull(createProduct);
        assertEquals(product.getId(), createProduct.getId());
        assertEquals(product.getProduct_name(), createProduct.getProduct_name());
        assertEquals(product.getProduct_price(), createProduct.getProduct_price());
        assertEquals(product.getProduct_inventory(), createProduct.getProduct_inventory());
        assertEquals(product.getCategory(), createProduct.getCategory());
    }
}