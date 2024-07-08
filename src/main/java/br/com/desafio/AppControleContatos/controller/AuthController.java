package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.configuration.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Operation(summary = "Gera um token de acesso para API.")
    @GetMapping
    public ResponseEntity<?> criarToken(@RequestParam String username) {
        String token = jwtTokenUtil.criarToken(username);
        return ResponseEntity.ok(token);
    }
}
