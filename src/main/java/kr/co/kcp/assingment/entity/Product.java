package kr.co.kcp.assingment.entity;

import jakarta.persistence.*;
import kr.co.kcp.assingment.constant.Category;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 상품명 **/
    private String product_name;

    /** 상품 가격 **/
    private BigDecimal product_price;

    /** 상품 재고량 **/
    private int product_inventory;

    /** 카테고리 **/
    @Enumerated(EnumType.STRING)
    private Category category;
}
