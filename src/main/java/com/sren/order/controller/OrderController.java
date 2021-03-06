package com.sren.order.controller;

import com.sren.order.VO.ResultVO;
import com.sren.order.converter.OrderForm2OrderDTOConverter;
import com.sren.order.dto.OrderDTO;
import com.sren.order.enums.ResultEnum;
import com.sren.order.exception.OrderException;
import com.sren.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renshuai
 * @create 2018-04-25 19:51
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     * 1. 校验参数
     * 2. 查询商品信息
     * 3. 计算总价
     * 4. 扣库存
     * 5. 订单入库
     */
    @PostMapping("/creat")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确， orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单] 购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

}
