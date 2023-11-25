package com.example.coursemanager.security.service;

import com.example.coursemanager.security.model.ApplicationUserDetails;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.UserJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public ApplicationUserDetailsService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userJpaRepository.findByUsername(username));

        return new ApplicationUserDetails(
                userOptional.orElseThrow(()-> new UsernameNotFoundException("User with username " + username + " not found."))
        );
    }

}
