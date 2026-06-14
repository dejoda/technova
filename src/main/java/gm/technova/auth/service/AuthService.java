package gm.technova.auth.service;

import gm.technova.auth.dto.LoginRequest;
import gm.technova.auth.dto.LoginResponse;
import gm.technova.commons.security.jwt.JwtService;
import gm.technova.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());

        var usuario = usuarioRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("rol", usuario.getRol().getNombre());
        extraClaims.put("id", usuario.getId());

        long expiration = usuario.getRol().getNombre().equals("ADMIN")
                ? 3600000L
                : 86400000L;

        String token = jwtService.generateToken(extraClaims, userDetails, expiration);

        String rol = usuario.getRol().getNombre();

        return new LoginResponse(token, request.username(), rol);
    }
}