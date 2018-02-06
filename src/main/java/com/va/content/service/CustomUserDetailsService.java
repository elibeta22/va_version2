package com.va.content.service;

import com.va.content.models.User;
import com.va.content.repositories.UserRepository;
import com.va.content.repositories.UserRoleRepository;
import com.va.content.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eli on 2/5/2018.
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository=userRolesRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);

        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles=userRoleRepository.findRoleByUsername(username);
            LOG.info(userRoles.toString());
            return new CustomUserDetails(user,userRoles);


        }

    }

}
