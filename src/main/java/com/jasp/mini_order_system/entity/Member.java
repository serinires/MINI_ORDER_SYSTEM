package com.jasp.mini_order_system.entity;
import com.jasp.mini_order_system.entity.Account;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Member extends Common {

    // 회원 이메일
    private String email;
    // 회원 비밀번호
    private String password;
    // 회원 닉네임
    private String nickname;
    // 회원 계좌
    private Account account;

}