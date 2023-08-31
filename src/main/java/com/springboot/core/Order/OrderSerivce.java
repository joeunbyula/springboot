package com.springboot.core.Order;

public interface OrderSerivce {
    Order creatOrder(Long memberId, String itemName, int itemPrice);
}
