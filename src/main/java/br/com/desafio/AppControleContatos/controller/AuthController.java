package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.configuration.JwtTokenUtil;
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

    @GetMapping
    public ResponseEntity<?> criarToken(@RequestParam String username) {
        String token = jwtTokenUtil.criarToken(username);
        return ResponseEntity.ok(token);
    }
}
