package com.byteworks.bytemealAPI.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

import com.byteworks.bytemealAPI.Entity.Developer;
import com.byteworks.bytemealAPI.Repository.DeveloperRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private DeveloperRepository applicationUserRepository;

    public UserDetailsServiceImpl(DeveloperRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Developer applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}