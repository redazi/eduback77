package ma.emsi.edu.security;

import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.auth0.jwt.interfaces.JWTVerifier;

import ma.emsi.edu.http.UserPrincipal;

@Component
public class JWTTokenProvider {
	@Value("${jwt.secret}")
	private String secret ;
	
	public String generateJWtToken(UserPrincipal userPrincipal) {
		String[] claims =  getClaimsFromUser(userPrincipal) ;
		return JWT.create().withIssuer(SecurityConstant.GET_ARRAYS_LLC).withAudience(SecurityConstant.GET_ARRAYS_ADMINISTRATION)
				.withIssuedAt(new Date()).withSubject(userPrincipal.getUsername()).withArrayClaim(SecurityConstant.AUTHORITIES, claims)
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(secret.getBytes()));
	}
	
	public List<GrantedAuthority> getAuthorities(String token){
		String[] claims = getClaimsFromToken(token);
		return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	
	public Authentication getAuthentication(String username , List<GrantedAuthority> authorities , HttpServletRequest request) {
		UsernamePasswordAuthenticationToken up = new UsernamePasswordAuthenticationToken(username, null, authorities) ;
		up.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return up ;
	}
	
	public boolean isTokenValid(String username , String token) {
		JWTVerifier jv = getJWTVerifier(); 
		return StringUtils.isNoneEmpty(username) && isTokenExpired(jv , token);
	}
	
	public String getSubject(String token) {
		JWTVerifier verifier = getJWTVerifier();
		return verifier.verify(token).getSubject();
	}

	private boolean isTokenExpired(JWTVerifier jv, String token) {
		// TODO Auto-generated method stub
		Date expiration = jv.verify(token).getExpiresAt();
		return expiration.before(new Date());
	}

	private String[] getClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		
		JWTVerifier verifier = getJWTVerifier() ;

		return verifier.verify(token).getClaim(SecurityConstant.AUTHORITIES).asArray(String.class);
	}

	private JWTVerifier getJWTVerifier() {
		JWTVerifier verifier ;
		try {
			Algorithm algorithm = Algorithm.HMAC512(secret);
			verifier = JWT.require(algorithm).withIssuer(SecurityConstant.GET_ARRAYS_LLC).build();			
		} catch (JWTVerificationException e) {
			throw new JWTVerificationException(SecurityConstant.TOKEN_CANNOT_BE_VERIFIED);
		}
		return verifier;
	}

	private String[] getClaimsFromUser(UserPrincipal user) {
		List<String> authoroties = new ArrayList<>();
		for(GrantedAuthority ga : user.getAuthorities())
			authoroties.add(ga.getAuthority());
		return authoroties.toArray(new String[0]);
	}

}
