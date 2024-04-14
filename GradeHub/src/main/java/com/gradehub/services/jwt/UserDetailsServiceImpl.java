package com.gradehub.services.jwt;

import com.gradehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.gradehub.entities.User> userOptional = userRepository.findFirstByEmail(email);
        if (userOptional.isEmpty()) throw new UsernameNotFoundException("Username not found",null);
        return new org.springframework.security.core.userdetails.User(userOptional.get().getUsername(),userOptional.get().getPassword(),new ArrayList<>());
    }
}
