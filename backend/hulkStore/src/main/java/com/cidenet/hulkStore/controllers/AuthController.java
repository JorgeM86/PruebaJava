package com.cidenet.hulkStore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.entities.UsersDTO;
import com.cidenet.hulkStore.security.jwt.JwtProvider;
import com.cidenet.hulkStore.security.jwt.JwtResponse;
import com.cidenet.hulkStore.services.UsersServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
public class AuthController {
	
	@Autowired
	private UsersServices services;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@PostMapping(path="/api/auth/sign_in", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> attemptAuthentication(@RequestParam("auth_email") String email, 
    		@RequestParam("auth_pass") String password) {
        Response response = new Response();
        HttpStatus httpStatus = null;
        try {
        	String status = services.authUser(email, password);
        	if (status.equals("APPROVED")) {
        		Authentication authentication = authenticationManager
                      .authenticate(new UsernamePasswordAuthenticationToken(email, password));
        		SecurityContextHolder.getContext().setAuthentication(authentication);
        		String jwt = jwtProvider.generateJwtToken(authentication);
        		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        		response.setData(new JwtResponse(jwt, userDetails.getUsername()));
        		httpStatus = HttpStatus.OK;
        	} else {
        		response.setMessage("Correo y/o contraseña incorrectos.");
        		httpStatus = HttpStatus.NOT_FOUND;
        	}
        	response.setStatus(status);
        } catch (Exception e) {
            response.setStatus("ERROR");
            response.setMessage(e.toString());
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
	
	@PostMapping(path="/api/auth/sign_up", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> attemptRegistration(@RequestParam("new_user") String json) {
        Response response = new Response();
        HttpStatus httpStatus = null;
        try {
            UsersDTO userDTO = new ObjectMapper().readValue(json, UsersDTO.class);
            String status = services.registrateUser(userDTO);
            if (status.equals("APPROVED")) {
            	response.setStatus(status);
            	httpStatus = HttpStatus.OK;
            } else {
            	response.setStatus(status);
            	httpStatus = HttpStatus.FOUND;
            	response.setMessage("Este correo ya existe");
            }
        } catch (Exception e) {
            response.setStatus("ERROR");
            response.setMessage(e.toString());
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
	
//	@PostMapping(path="/api/auth/sign_in", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Response> attemptAuthentication(@RequestParam("auth_email") String email, 
//    		@RequestParam("auth_pass") String password) {
//        Response response = new Response();
//        HttpStatus httpStatus = null;
//        try {
//        	String status = null;
//            UsersDTO user = repository.findByEmail(email);
//            if (user != null) {
//            	if (encoder.matches(password, user.getPassword())) {
//            		Authentication authentication = authenticationManager
//                            .authenticate(new UsernamePasswordAuthenticationToken(email, password));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    String jwt = jwtProvider.generateJwtToken(authentication);
//                    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//                    response.setData(new JwtResponse(jwt, userDetails.getUsername()));
//                    httpStatus = HttpStatus.OK;
//                    status = "APPROVED";
//            	} else {
//            		response.setMessage("Correo y/o contraseña incorrectos.");
//                    httpStatus = HttpStatus.NOT_FOUND;
//                    status = "BAD_CREDENTIALS";
//            	}
//            } else {
//            	response.setMessage("Correo y/o contraseña incorrectos.");
//                httpStatus = HttpStatus.NOT_FOUND;
//                status = "NOT_FOUND";
//            }
//            response.setStatus(status);
//        } catch (Exception e) {
//            response.setStatus("ERROR");
//            response.setMessage(e.toString());
//        }
//        return new ResponseEntity<>(response, httpStatus);
//    }

//	@PostMapping(path="/api/auth/sign_up", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Response> attemptRegistration(@RequestParam("new_user") String json) {
//        Response response = new Response();
//        HttpStatus httpStatus = null;
//        try {
//            UsersDTO userDTO = new ObjectMapper().readValue(json, UsersDTO.class);
//            UsersDTO user = repository.findByEmail(userDTO.getEmail());
//            if (user == null) {
//            	userDTO.setPassword(encoder.encode(userDTO.getPassword()));
//                userDTO.setRegistration_date(new Date());
//                repository.save(userDTO);
//                response.setStatus("APPROVED");
//                httpStatus = HttpStatus.OK;
//            } else {
//            	response.setStatus("USER_FOUND");
//            	response.setMessage("Este correo ya existe");
//            	httpStatus = HttpStatus.FOUND;
//            }
//        } catch (Exception e) {
//            response.setStatus("ERROR");
//            response.setMessage(e.toString());
//            httpStatus = HttpStatus.CONFLICT;
//        }
//        return new ResponseEntity<>(response, httpStatus);
//    }
}
