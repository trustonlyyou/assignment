package kr.co.kcp.assingment.domain.order.repository;

import kr.co.kcp.assingment.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
