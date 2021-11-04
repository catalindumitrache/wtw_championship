package com.wtw.championship.model.repository;


import com.wtw.championship.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
        @Query(value="select u.* from user u join user_roles ur on u.user_id = ur.user_id where ur.role_id = :role_id",
                nativeQuery = true)
        List<User> findByRoleId(@Param("role_id") Long role_id);


}