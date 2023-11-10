package com.miu.pmtbackendapi.service.user;

import com.miu.pmtbackendapi.domain.user.response.Users;
import com.miu.pmtbackendapi.domain.user.request.UserDTO;
import com.miu.pmtbackendapi.domain.user.response.UserResponse;

import java.util.Optional;

public interface UserService {

    Users getAllUsers();

    Optional<UserResponse> getUser(Long id);

    UserResponse saveUser(UserDTO userDTO);

    Boolean deleteUser(Long userId);

}
