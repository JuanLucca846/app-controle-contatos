package br.com.desafio.AppControleContatos.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private String segredo = "fjsapfjkidajfmvkoifsdiojpfipsojifdsoijeunvjckfsdhueihfuejnjvisniq";
    private long expiracao = 3600000;

    public String criarToken(String username) {
        Date data = new Date();
        Date validade = new Date(data.getTime() + expiracao);

        byte[] apiKeySecretByte = Base64.getEncoder().encode(segredo.getBytes());
        Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretByte);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(data)
                .setExpiration(validade)
                .signWith(segredoKey)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            byte[] apiKeySecretByte = Base64.getEncoder().encode(segredo.getBytes());
            Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretByte);

            Jws<Claims> claims = Jwts.parser().setSigningKey(apiKeySecretByte)
                    .parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            byte[] apiKeySecretByte = Base64.getEncoder().encode(segredo.getBytes());
            Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretByte);

            Jws<Claims> claims = Jwts.parser().setSigningKey(apiKeySecretByte)
                    .parseClaimsJws(token);

            return claims.getBody().getSubject();
        } catch (Exception e) {
            return "";
        }
    }
}
