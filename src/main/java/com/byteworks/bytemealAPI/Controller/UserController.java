package com.byteworks.bytemealAPI.Controller;



import com.byteworks.bytemealAPI.Entity.Developer;
import com.byteworks.bytemealAPI.Exception.ResourceNotFoundException;
import com.byteworks.bytemealAPI.Repository.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

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
  public Developer signUp(@RequestBody Developer user) {
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


 
}
