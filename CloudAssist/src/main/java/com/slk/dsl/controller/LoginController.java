package com.slk.dsl.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.JWTConfig.JwtTokenUtil;
import com.slk.dsl.model.JwtRequest;
import com.slk.dsl.model.JwtResponse;
import com.slk.dsl.model.Org;
import com.slk.dsl.model.UserDTO;
import com.slk.dsl.repository.OrganizationDao;
import com.slk.dsl.repository.UserDao;
import com.slk.dsl.services.JwtUserDetailsService;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userRepository;
    
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil tokenProvider;
    
    
    
   


    @Autowired
	private JwtUserDetailsService userDetailsService;

/*    @RequestMapping("status")
    public ResponseEntity<?> serverStatus(){
    	return new ResponseEntity<>(new ApiResponse ("server is running",""),HttpStatus.OK);
    }
    
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(loginRequest.getUserName());
        String jwt = tokenProvider.generateToken(userDetails);
        JSONObject obj=this.getUserResponse(jwt);
        if(obj==null) {
        	throw new Exception("error while generating Response");
        }
        
        return new ResponseEntity<String>(obj.toString(),HttpStatus.OK);
        
    
    }
	private JSONObject getUserResponse(String jwt) {
		// TODO Auto-generated method stub
		try {
			
			User user=userServices.findById(_getUserId());
			HashMap<String, String>response=new HashMap<String, String>();
			response.put("user_id",""+_getUserId());
			response.put("mail", user.getEmail_Id());
			JSONObject obj=new JSONObject();
			obj.put("user dt", response);
			obj.put("token",jwt);
			return obj;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	private long _getUserId() {
		// TODO Auto-generated method stub
		UserPrincipal userPrincipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return userPrincipal.getId();
	}}*/
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    	try {

//    		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		String encryptedassword = userRepository.getPasswordforUser(authenticationRequest.getEmail());
		String encryptedloginpassword = Base64.getEncoder().encodeToString(authenticationRequest.getPassword().getBytes());
		if(encryptedassword == null) {
			DisabledException e = new DisabledException("USER_DISABLED");
			return  ResponseEntity.of(Optional.empty());
			
		}else if(!encryptedassword.equals(encryptedloginpassword) ){
			return  ResponseEntity.of(Optional.empty());
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());

		final String token = tokenProvider.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
		
    	}
    	catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e); 	
		}
	}
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
    
    
    
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e); 	
		}
	}

	
	 
	 
	 
	 
}