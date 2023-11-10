package com.miu.pmtbackendapi.resource.auth;

import com.miu.pmtbackendapi.domain.auth.dto.request.LoginRequest;
import com.miu.pmtbackendapi.service.auth.AuthService;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);

        ResponseCookie cookie = ResponseCookie.from("refreshToken", loginResponse.getRefreshToken())
                .httpOnly(true)
                .maxAge(24 * 60 * 60) //24 hours
                .path("/")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.ok().headers(httpHeaders).body(loginResponse);
    }

//    @PostMapping("/refreshToken")
//    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        return authService.refreshToken(refreshTokenRequest);
//    }

    @PostMapping(path = "/token/refresh/")
    public ResponseEntity<?> validateAccessTokenFromRefreshToken() throws ServletException {
        return ResponseEntity.ok().body(authService.refreshTokenAPI());
    }

}
