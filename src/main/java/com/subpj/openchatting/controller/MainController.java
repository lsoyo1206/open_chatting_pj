package com.subpj.openchatting.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // 테스트 페이지
    @GetMapping("/test")
    public String list() {
        return "=================index test ===============";
    }
}
