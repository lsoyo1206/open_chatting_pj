package com.subpj.openchatting.controller;


import com.subpj.openchatting.domain.UserDto;
import com.subpj.openchatting.service.SaveUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SaveUserController {

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(UserDto userDto) {
        System.out.print("회원가입 ================>");
        SaveUserService.saveUser(userDto);
        return "redirect:/login"; //로그인 구현 예정
    }
}
