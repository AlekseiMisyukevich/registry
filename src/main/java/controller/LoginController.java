package controller;

import javax.security.auth.login.FailedLoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.AuthenticationResponse;
import model.UserCredentials;
import service.serviceImpl.UserAuthenticationService;

@RestController
public class LoginController {
	
	@Autowired
	private UserAuthenticationService authenticationService;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@RequestBody UserCredentials userCredentials) throws FailedLoginException {
 
        if (userCredentials == null || (userCredentials.getUsername() == null || userCredentials.getPassword() == null)) {
            throw new FailedLoginException("Missing login credentials");
        }
 
        String token = authenticationService.authenticateUser(userCredentials.getUsername(), userCredentials.getPassword());
 
        if (token != null) {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setUsername(userCredentials.getUsername());
            authenticationResponse.setToken(token);
            logger.info("Returning token {}", token);
            return new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
        }
        throw new FailedLoginException(String.format(" unable to authenticate user [%s] ", userCredentials.getUsername()));
    }
	
}
