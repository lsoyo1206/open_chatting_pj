package com.subpj.openchatting.domain;

import lombok.Data;

@Data
public class UserDto {
    // 로그인 기능
    private String createDt;
    private int no;
    private String profilImageUrl;
    private String backGroundUmageUrl;
    private String name;
    private String userId;
    private String userPw;
    private String isDeleted;

}
