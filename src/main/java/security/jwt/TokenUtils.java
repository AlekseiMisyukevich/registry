package security.jwt;

import static java.time.ZoneOffset.UTC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {
	
	private final String privateKey = "MIIBOQIBAAJAa19OYYxj8wqq/dz2twln6FyT10m4yB/SyEuMj31hejAUPeaeSrr997MyybtDugVGKDUQ3GMbhKon4C898/1+ewIDAQABAkBIyq4Kt/CyvlK";
	
	private static final String ISSUER = "com.university.journal";
	
	public TokenUtils () {
		//
	}
	
	public String generateToken(String username) throws IOException, URISyntaxException {

		
		Date expiration = Date.from(LocalDateTime.now(UTC).plusHours(1).toInstant(UTC));
		return Jwts.builder().setIssuer(ISSUER).setSubject(username).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, privateKey).compact();
		
	}
	
	public String verifyToken(String token) throws IOException, URISyntaxException {
        
		Jws<Claims> claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token);
        
        return claims.getBody().getSubject();
    }
	
}