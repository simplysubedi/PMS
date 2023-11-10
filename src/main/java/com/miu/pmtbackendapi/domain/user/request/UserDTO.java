package com.miu.pmtbackendapi.domain.user.request;

import com.miu.pmtbackendapi.domain.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Collection<Role> roles;
}
