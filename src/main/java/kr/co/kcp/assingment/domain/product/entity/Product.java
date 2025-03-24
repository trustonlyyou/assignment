package kr.co.kcp.assingment.domain.product.entity;

import jakarta.persistence.*;
import kr.co.kcp.assingment.common.constant.Category;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    /** 상품명 **/
    private String productName;

    /** 상품 가격 **/
    private BigDecimal productPrice;

    /** 상품 재고량 **/
    private int productInventory;

    /** 카테고리 **/
    @Enumerated(EnumType.STRING)
    private Category category;

    public void updateProductName(String newName) {
        this.productName = newName;
    }

    public void updateProductPrice(BigDecimal newPrice) {
        this.productPrice = newPrice;
    }

    public void updateProductInventory(int newInventory) {
        this.productInventory = newInventory;
    }

    public void updateCategory(Category newCategory) {
        this.category = newCategory;
    }

    public void updateProduct(Product newProduct) {
        this.productName = newProduct.getProductName();
        this.productPrice = newProduct.getProductPrice();
        this.productInventory = newProduct.getProductInventory();
        this.category = newProduct.getCategory();
    }

    public void decreaseProductInventory(int inventory) {
        if (productInventory - inventory < 0) {
            throw new IllegalArgumentException("재고 부족");
        }

        this.productInventory -= inventory;
    }
}
