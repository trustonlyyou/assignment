package kr.co.kcp.assingment.domain.order.repository;

import kr.co.kcp.assingment.common.constant.Category;
import kr.co.kcp.assingment.common.constant.OrderStatus;
import kr.co.kcp.assingment.domain.order.entity.Order;
import kr.co.kcp.assingment.domain.product.entity.Product;
import kr.co.kcp.assingment.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("주문 생성 테스트")
    public void createOrderTest() throws Exception {
        //given
        Product product = Product.builder()
                .productName("PLAC Jean")
                .productPrice(new BigDecimal(100000))
                .productInventory(10)
                .category(Category.BOTTOM)
                .build();

        productRepository.save(product);

        Order order = Order.builder()
                .orderNo(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.RECEIVED)
                .product(product)
                .build();

        //when
        orderRepository.save(order);

        //then
        assertNotNull(order.getOrderNo());
    }
}