package com.subpj.openchatting.service;

import com.subpj.openchatting.domain.UserDto;
import com.subpj.openchatting.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginUserService {

    private final UserRepository userRepository;

    public UserDto login(String userId, String userPw) {
        return userRepository.findByLoginId(userId)
                .filter(m -> m.getUserPw().equals(userPw))
                .orElse(null);
    }

}
