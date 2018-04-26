package com.sren.order.repository;

import com.sren.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author renshuai
 * @create 2018-04-24 23:21
 **/

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
