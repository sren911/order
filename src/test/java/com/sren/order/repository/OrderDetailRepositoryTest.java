package com.sren.order.repository;

import com.sren.order.OrderApplicationTests;
import com.sren.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("111");
        orderDetail.setOrderId("222");
        orderDetail.setProductIcon("hdkahd");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductId("222");
        orderDetail.setProductPrice(new BigDecimal(1));
        orderDetail.setProductQuantity(5);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}