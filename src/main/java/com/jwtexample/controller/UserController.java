package com.jwtexample.controller;

import com.jwtexample.entity.AuthRequest;
import com.jwtexample.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@GetMapping("/")
	public String greeting() {
		return "Welcome!";
	}

	@PostMapping("/authenticate")
	public String genrateToken(@RequestBody AuthRequest authrequest) throws Exception {
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
		}
		catch(Exception e) {
			throw new Exception ("Invalid username and passwor");
		}
		return jwtutil.generateToken(authrequest.getUsername());
		
	}
}
