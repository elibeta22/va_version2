package com.va.content.repositories;

/**
 * Created by eli on 2/4/2018.
 */

import com.va.content.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    @Query("select a.role from UserRole a, User b where b.username=?1 and a.user_id=b.id")
    List<String> findRoleByUsername(String username);

}