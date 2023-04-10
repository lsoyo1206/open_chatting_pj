package com.subpj.openchatting.controller;

import com.subpj.openchatting.domain.MemberDto;
import com.subpj.openchatting.domain.SessionConstants;
import com.subpj.openchatting.domain.UserDto;
import com.subpj.openchatting.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginUserService loginUserService;

    // 로그인 호출
    @GetMapping("/login")
    public String loginForm(@ModelAttribute UserDto userDto) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated UserDto userDto,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL) {
        System.out.println("로그인 기능 ===========>");

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        UserDto loginUser = loginUserService.login(userDto.getUserId(), userDto.getUserPw());

        // 로그인 비밀번호가 맞지 않으면
        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        // 로그인 성공 처리
        return "redirect:" + redirectURL;
    }

    // 로그아웃 처리
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "redirect:/";
    }


    // 로그인 데이터 없을떄
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_USER, required = false) Member loginMember, Model model) {
        // 세션에 회원 데이터가 없으면 홈으로 이동
        if (loginMember == null) {
            return "home";
        }

        // 세션이 유지되면 로그인 홈으로 이동
        model.addAttribute("member", loginMember);

        return "loginHome";
    }

}
