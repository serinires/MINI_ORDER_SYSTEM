package com.jasp.mini_order_system.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Item extends Common {

    // 상품 이름
    // 상품 가격
    // 상품 카테고리

    private String itemName;
    private int itemPrice;
    private Category category;


}