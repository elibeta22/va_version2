package com.va.content.service;

import com.va.content.models.User;
import com.va.content.models.UserRole;
import com.va.content.repositories.UserRepository;
import com.va.content.repositories.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eli on 2/4/2018.
 */
@Service("userService")
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static int workload = 12;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional
    public User createUser(User user) throws Exception{
        logger.info("Validating user in service: {}", user);
        String username = user.getUsername();
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null){
            throw new Exception("User already exists.");
        }

        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashed_password);
        User createdUser = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUser_id(user.getId());
        userRoleRepository.save(userRole);
        return createdUser;
    }


}
