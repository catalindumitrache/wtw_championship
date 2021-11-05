package com.wtw.championship.service.impl;

import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.model.repository.IRoleRepository;
import com.wtw.championship.model.repository.IUserRepository;
import com.wtw.championship.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void mapRoleToUser(Long roleId, Long userId) throws Exception {
        Optional<User> optUser = userRepository.findById(userId);
        Optional<Role> optRole = roleRepository.findById(roleId);
        User user;
        Role role;
        if(!optUser.isPresent()) {
            throw new Exception ("User + " + userId + " could not be found.");
        } else {
            user = optUser.get();
        }
        if(!optRole.isPresent()) {
            throw new Exception ("Role + " + roleId + " could not be found.");
        } else {
            role = optRole.get();
        }
        Role existingRole = user.containsRole(role);
        if(existingRole == null){
            user.addRole(role);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getUsersByRole(Long roleId) {
        return userRepository.findByRoleId(roleId);
    }

    @Override
    public User addUser(User user) throws Exception {
        return userRepository.save(user);
    }

}
