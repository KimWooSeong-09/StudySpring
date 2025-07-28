package com.spring.e0723.dto;

import com.spring.e0723.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MemberForm {
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(null, email, password);
    }

    @Override
    public String toString() {
        return "MemberForm{ID='" + email + "', PassWord='" + password + "'}";
    }
}
