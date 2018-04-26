package com.sren.order.service.impl;

import com.sren.order.dataobject.OrderMaster;
import com.sren.order.dto.OrderDTO;
import com.sren.order.enums.OrderStatusEnum;
import com.sren.order.enums.PayStatusEnum;
import com.sren.order.repository.OrderDetailRepository;
import com.sren.order.repository.OrderMasterRepository;
import com.sren.order.service.OrderService;
import com.sren.order.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author renshuai
 * @create 2018-04-25 20:00
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     *  查询商品信息 TODO
     *  计算总价 TODO
     *  扣库存 TODO
     *  订单入库
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
