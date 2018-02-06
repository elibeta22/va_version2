package com.va.content.repositories;

/**
 * Created by eli on 2/3/2018.
 */

import com.va.content.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional(readOnly = true)
    public User findByUsername(String username);

}
