package service.serviceImpl;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.security.auth.login.FailedLoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import exception.JwtAuthenticationException;
import model.User;
import security.jwt.TokenUtils;

@Service
public class UserAuthenticationService {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsServiceImpl userService;

	private User user;

	public UserAuthenticationService() {
		//
	}

	public String authenticateUser(String username, String password) throws FailedLoginException {

		boolean isAuthenticated = false;

		try {
			user = userService.loadUserByUsername(username);
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		}

		isAuthenticated = (user.getUsername().equals(username) && user.getPassword().equals(password)) ? true : false;

		if (isAuthenticated) {
			try {
				return tokenUtils.generateToken(username);
			} catch (URISyntaxException | IOException e) {
				throw new FailedLoginException(e.getMessage());
			}
		}

		throw new FailedLoginException("User not found");
	}

	@SuppressWarnings("unchecked")
	public User authenticateToken(String token) {

		try {		
			
			String username = tokenUtils.verifyToken(token);
			User user = userService.loadUserByUsername(username);			
			
			return user;
			

		} catch (IOException | URISyntaxException | UsernameNotFoundException e) {
			throw new JwtAuthenticationException(e.getMessage(), e);
		}
	}
}
