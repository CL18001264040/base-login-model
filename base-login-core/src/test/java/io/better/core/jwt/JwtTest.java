package io.better.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

/**
 * @author better
 * @date create in 2018/11/16 3:43 PM
 */
public class JwtTest {

    @Test
    public void testJwtCreate() {
        String jwtToken = Jwts.builder()
                .setId("1")
                .setSubject("test")
                .signWith(SignatureAlgorithm.HS256, "better")
                .compact();
        System.out.println(jwtToken);
    }

    @Test
    public void testParseJwtToken() {

        Claims claims = Jwts.parser().setSigningKey("better")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoidGVzdCJ9.7BO6I3K8qZpxP69nymOdpaeX7OfvPmZFE3b4e77A80Y")
                .getBody();

        System.out.println(claims);
    }
}
