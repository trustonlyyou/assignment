package kr.co.kcp.assingment.domain.order.entity;

import jakarta.persistence.*;
import kr.co.kcp.assingment.common.constant.OrderStatus;
import kr.co.kcp.assingment.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    /** 상태 **/
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    /** 주문상태 **/
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, unique = true)
    private String orderNo;

}
