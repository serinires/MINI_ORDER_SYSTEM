package com.jasp.mini_order_system.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Account extends Common {

    // 계좌 번호
    private String accountNumber;
    // 계좌 잔액
    private int balance;

    // 출금 메서드
    public void withdraw(int amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("출금 후 잔액 : "+balance);
        }
        else {
            System.out.println("잔액이 부족합니다.");
        }
    }
    // 입금 메서드
    public void deposit(int amount){
        balance += amount;
        System.out.println("입금 후 잔액 : "+balance);
    }

}