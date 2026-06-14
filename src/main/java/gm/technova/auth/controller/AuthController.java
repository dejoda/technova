package gm.technova.auth.controller;

import gm.technova.auth.dto.LoginRequest;
import gm.technova.auth.dto.LoginResponse;
import gm.technova.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        System.out.println(">>> LLEGÓ AL CONTROLLER: " + request.username());
        return ResponseEntity.ok(authService.login(request));
    }
}