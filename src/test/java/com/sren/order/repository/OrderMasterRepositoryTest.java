package com.sren.order.repository;

import com.sren.order.OrderApplicationTests;
import com.sren.order.dataobject.OrderMaster;
import com.sren.order.enums.OrderStatusEnum;
import com.sren.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("北京");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerOpenid("111");
        orderMaster.setOrderId("123");
        orderMaster.setBuyerPhone("10010");
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(new BigDecimal(100));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}