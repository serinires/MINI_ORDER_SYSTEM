package com.jasp.mini_order_system.entity;
import com.jasp.mini_order_system.entity.Member;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
@EqualsAndHashCode(callSuper=true)


public class Order extends Common {

    // 주문 회원
    public Member member;
    // 주문한 상품 목록
    private List<Item> orderedItemList;
    // 주문 코드
    private String orderCode;
    // 주문 날짜
    private LocalDateTime orderDate;
    // 총 상품 수량
    private int totalItemCount;
    // 총 상품 금액
    private int totalItemAmount;

    // 생성자
    public Order(Member member, List<Item> orderedItemList) {
        this.member = member;
        this.orderedItemList = orderedItemList != null ? orderedItemList : new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.totalItemCount = orderedItemList.size();
        this.orderCode = UUID.randomUUID().toString();
        this.totalItemAmount =0;
        // 주문 생성 로직

        for (Item item : this.orderedItemList) {
            this.totalItemAmount += item.getItemPrice();
        }
    }

    // 상품 추가 메서드
    public void addItem(Item item) {
        updateOrder(item, item.getItemPrice(), true);
    }
    // 상품 제거 메서드
    public void removeItem(Item item){
        updateOrder(item, item.getItemPrice(), false);
    }

    // 주문 업데이트 메서드
    private boolean updateOrder(Item item, int price, boolean isAdd) {
        if (isAdd) {
            // 상품 추가 로직
            orderedItemList.add(item);
            totalItemAmount += price;
            totalItemCount ++;
            // 주문 목록에 item 추가
            // totalItemAmount에 price 추가
            // totalItemCount 증가
        } else {
            // 상품 제거 로직
            orderedItemList.remove(item);
            totalItemAmount -= price;
            totalItemCount --;
            // 주문 목록에서 item 제거
            // totalItemAmount에서 price 감소
            // totalItemCount 감소
        }
        return true;
    }

}