package com.wtw.championship.model.repository;


import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

//    List<Role> findAllByNameAndUser_id(String name, Long userId);
}