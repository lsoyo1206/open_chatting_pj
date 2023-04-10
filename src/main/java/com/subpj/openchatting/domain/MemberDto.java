package com.subpj.openchatting.domain;

import lombok.Data;

@Data
public class MemberDto {

    private int roomNo;
    private String userId;
    private String createAt;

}
