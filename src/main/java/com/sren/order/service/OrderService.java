package com.sren.order.service;

import com.sren.order.dataobject.OrderDetail;
import com.sren.order.dataobject.OrderMaster;
import com.sren.order.dto.OrderDTO;

/**
 * @author renshuai
 * @create 2018-04-25 19:52
 **/

public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
