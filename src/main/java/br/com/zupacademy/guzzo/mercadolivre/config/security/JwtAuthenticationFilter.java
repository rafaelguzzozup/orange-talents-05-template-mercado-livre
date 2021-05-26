package br.com.zupacademy.guzzo.mercadolivre.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private TokenManager tokenManager;
	private UsersService usersService;

	public JwtAuthenticationFilter(TokenManager tokenManager, UsersService usersService) {
		this.tokenManager = tokenManager;
		this.usersService = usersService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);

		if (token != null && tokenManager.isTokenValido(token)) {
			String username = tokenManager.getUsername(token);
			UserDetails userDetails = usersService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}

		filterChain.doFilter(request, response);

	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
