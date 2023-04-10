package com.subpj.openchatting.service;

import com.subpj.openchatting.domain.UserDto;
import com.subpj.openchatting.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SaveUserService {

    // 회원가입
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    static
    UserMapper userMapper;

    @Transactional
    public static void saveUser(UserDto userDto){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userMapper.saveUser(userDto);
    }

}
