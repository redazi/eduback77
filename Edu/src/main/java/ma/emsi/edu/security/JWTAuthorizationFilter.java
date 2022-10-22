package ma.emsi.edu.security;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import ma.emsi.edu.service.UtilisateurService;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	JWTUtils jwtUtils ;
	
	@Autowired
	UtilisateurService utilisateurService;
		
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		String username = null ;
		String jwt = null;
		if(StringUtils.hasLength(authHeader) && authHeader.startsWith("Bearer")) {
			jwt = authHeader.substring(7) ;
			username = jwtUtils.extractUsername(jwt);
		}
		
		if(StringUtils.hasLength(username) && SecurityContextHolder.getContext().getAuthentication()==null ) {
			UserDetails userDetails = utilisateurService.loadUserByUsername(username);
			if(jwtUtils.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		System.out.println("from filter " + username);
		
		filterChain.doFilter(request, response);
	}

}
