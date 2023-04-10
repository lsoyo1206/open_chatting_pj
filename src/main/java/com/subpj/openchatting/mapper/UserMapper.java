package com.subpj.openchatting.mapper;

import com.subpj.openchatting.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(UserDto userDto);
}
