package com.miu.pmtbackendapi.service.user.adapter;

import com.miu.pmtbackendapi.domain.user.User;
import com.miu.pmtbackendapi.domain.user.response.UserResponse;
import com.miu.pmtbackendapi.domain.user.response.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserAdapter {
    private final ModelMapper modelMapper;

    public <T, U> U convertObject(T object, Class<U> targetClass) {
        return modelMapper.map(object, targetClass);
    }

    public Users getResponsesForAllUsers(List<User> allUsers) {
        List<UserResponse> dtos = allUsers.stream().map(user -> {
            UserResponse res = convertObject(user, UserResponse.class);
            return res;
        }).collect(Collectors.toList());

        return new Users(dtos.size(), dtos);
    }
}
