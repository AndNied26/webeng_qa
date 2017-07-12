package com.example.demo.application.service;

import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * this class sets up our own implementation of UserDetailService.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * A constructor, which sets the local repository to the actual repository.
     *
     * @param userRepository the userRepository.
     */
    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Generate a UserDetail-object for spring security.
     *
     * @param s th name of the user a userdetail-object is needed for.
     * @return a useerDetail-object.
     * @throws UsernameNotFoundException if the username is not found in the userRepository.
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("Didn't find user with id " + s);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    /**
     * A getter-method for all the roles the user has.
     *
     * @param user the given user.
     * @return a Set of the roles the user has.
     */
    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
