package kr.co.kcp.assingment.repository;

import kr.co.kcp.assingment.constant.Category;
import kr.co.kcp.assingment.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상풍 저장 테스트")
    public void saveProductTest() throws Exception {
        //given
        Product product = Product.builder()
                .productName("PLAC Jean")
                .productPrice(new BigDecimal(100000))
                .productInventory(10)
                .category(Category.BOTTOM)
                .build();

        //when
        Product createProduct = productRepository.save(product);

        //then
        assertNotNull(createProduct);
        assertEquals(product.getId(), createProduct.getId());
        assertEquals(product.getProductName(), createProduct.getProductName());
        assertEquals(product.getProductPrice(), createProduct.getProductPrice());
        assertEquals(product.getProductInventory(), createProduct.getProductInventory());
        assertEquals(product.getCategory(), createProduct.getCategory());
    }


    @Test
    @DisplayName("상품 조회 테스트 카테고리 별")
    public void getProductByCategoryTest() throws Exception {
        //given
        Product product1 = Product.builder()
                .productName("PLAC Jean")
                .productPrice(new BigDecimal(100000))
                .productInventory(10)
                .category(Category.BOTTOM)
                .build();

        Product product2 = Product.builder()
                .productName("UNIQ Jean")
                .productPrice(new BigDecimal(200000))
                .productInventory(30)
                .category(Category.BOTTOM)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

        //when
        List<Product> products =  productRepository.findProductByCategory(Category.BOTTOM);

        //then
        assertEquals(2, products.size());
    }

    @Test
    @DisplayName("삼품 수정 테스트 카테고리 별")
    public void updProductByCategoryTest() throws Exception {
        //given
        Product product = Product.builder()
                .productName("PLAC Jean")
                .productPrice(new BigDecimal(100000))
                .productInventory(10)
                .category(Category.BOTTOM)
                .build();

        Product saveProduct = productRepository.save(product);

        //when
        saveProduct.updateProductName("UNIQ Jean");

        //then
        Product updateProduct = productRepository.findById(saveProduct.getId()).orElseThrow();

        System.out.println(updateProduct.toString());

        assertNotNull(updateProduct);
        assertEquals("UNIQ Jean", updateProduct.getProductName());
        assertEquals(BigDecimal.valueOf(100000), updateProduct.getProductPrice());
        assertEquals(10, updateProduct.getProductInventory());
        assertEquals(Category.BOTTOM, updateProduct.getCategory());
    }
}