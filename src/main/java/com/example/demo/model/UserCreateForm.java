package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;
    
    @Size(max = 25)
    @NotEmpty(message = "사용자 닉네임은 필수항목입니다.")
    private String username;

    @NotEmpty(message = "전화번호는 필수항목입니다.")
    private String phonenumber;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;


}