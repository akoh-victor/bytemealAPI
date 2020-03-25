package com.byteworks.bytemealAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.byteworks.bytemealAPI.Entity.Developer;
import com.byteworks.bytemealAPI.Repository.DeveloperRepository;



@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private DeveloperRepository userRepository;

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  

  public UserController(DeveloperRepository userRepository,
  BCryptPasswordEncoder bCryptPasswordEncoder) {
this.userRepository = userRepository;
this.bCryptPasswordEncoder = bCryptPasswordEncoder;

}


  /**
   * Register user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/developer/register")
  public Developer createUser(@Valid @RequestBody Developer user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/developer/{id}")
  public ResponseEntity<Developer> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    Developer user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }


  @PostMapping("/developer/login")
  public UsernamePasswordAuthenticationToken getToken(@RequestBody Developer user, HttpServletResponse response) {

  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword() ,new ArrayList<>());

 
  return authToken ;


  }
 
}
