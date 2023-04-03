package com.subpj.openchatting.controller;
import com.subpj.openchatting.domain.TestDto;
import com.subpj.openchatting.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    TestService testService;

    // 테스트 페이지
    @GetMapping("/test")
    public String list() {
        return "=================index test ===============";
    }

    @GetMapping("/api/hello")
    public List<String> Hello(){
        return Arrays.asList("서버서버", "뷰뷰");
    }

    @GetMapping("/test/time") //노테이션의 값으로 주소 지정
    public List<TestDto> selectBoardList() throws Exception{
        //templates 폴더 아래있는 /boardList.html을 의미함. Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출
        List<TestDto> list = testService.selectTestList();

        return list;

    }

    // 방 리스트 가져오기 테스트
    @GetMapping("/test/memberList") //어노테이션의 값으로 주소 지정
    public List<TestDto> selectMemberList() throws Exception{
        //templates 폴더 아래있는 /boardList.html을 의미함. Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출
        List<TestDto> list = testService.selectMemberList();

        return list;

    }


}
