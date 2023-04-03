package com.subpj.openchatting.service;

import com.subpj.openchatting.domain.TestDto;
import com.subpj.openchatting.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl extends TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestDto> selectTestList() throws Exception {
        return testMapper.selectTestList();
    }

    @Override
    public List<TestDto> selectMemberList() throws Exception {
        return testMapper.selectMemberList();
    }

}
