package com.sren.order.repository;

import com.sren.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author renshuai
 * @create 2018-04-24 23:22
 **/

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
