package com.subpj.openchatting.mapper;

import com.subpj.openchatting.domain.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDto> selectTestList() throws Exception;

    // 방리스트 가져오기
    List<TestDto> selectMemberList() throws Exception;
}
