package ge.ibsu.hospital.security.controller;

import ge.ibsu.hospital.security.dto.AuthenticationResponse;
import ge.ibsu.hospital.security.dto.LoginData;
import ge.ibsu.hospital.security.dto.RegistrationRequest;
import ge.ibsu.hospital.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginData request) {
        return ResponseEntity.ok(userService.login(request));
    }
}

