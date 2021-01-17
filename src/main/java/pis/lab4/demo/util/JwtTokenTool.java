package pis.lab4.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
@Slf4j
@Profile("security")
@Data
public class JwtTokenTool {

    @Value("${jwt.key}")
    private String key;

    @Value("${token.expiring}")
    private long expiring;

    @PostConstruct
    protected void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    public String createToken(String email) {
        String token = Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiring))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

        log.info("Created token: {}", token);

        return token;
    }

    public boolean validateToken(String token) {
        log.info("Validating token: {}", token);
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaim(token, Claims::getExpiration).before(new Date());
    }

    public <T> T getClaim(String token, Function<Claims, T> resolver) {
        Claims claims = getClaims(token);
        return resolver.apply(claims);
    }

    public <T> T getClaim(String token, String name) {
        Claims claims = getClaims(token);
        return (T) claims.get(name);
    }

    public String getEmail(String token) throws JwtException {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(this.key)
                .parseClaimsJws(token).getBody();
    }

}