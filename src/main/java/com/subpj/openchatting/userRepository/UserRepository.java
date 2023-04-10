package com.subpj.openchatting.userRepository;

import com.subpj.openchatting.domain.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
// 로그인 기능 구현
public class UserRepository {

    // 회원정보 ConcurrentHashMap 사용하여 메모리 저장
    private static Map<String, UserDto> store = new ConcurrentHashMap<String, UserDto>();
    private static long sequence = 0L;

    // 로그인 저장
    public UserDto save(UserDto userDto) {

        userDto.setUserId(String.valueOf(++sequence));
        store.put(userDto.getUserId(), userDto);

        return userDto;
    }

    public UserDto findById(String userId) {
        return this.findAll().stream()
                .filter(m -> m.getUserId().equals(userId))
                .findFirst().get();
    }

    public Optional<UserDto> findByLoginId(String loginId) {

        return this.findAll().stream()
                .filter(m -> m.getUserId().equals(loginId))
                .findFirst();
    }


    public List<UserDto> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

    @PostConstruct
    public void init() {

        UserDto userDto = new UserDto();
        userDto.setUserId("test");
        userDto.setUserPw("test!");
        userDto.setName("테스터");

        save(userDto);
    }
    
}
