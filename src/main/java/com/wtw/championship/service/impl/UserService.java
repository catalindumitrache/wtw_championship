package com.wtw.championship.service.impl;

import com.wtw.championship.model.dto.GenericResponseDTO;
import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.model.repository.IRoleRepository;
import com.wtw.championship.model.repository.IUserRepository;
import com.wtw.championship.service.IRoleService;
import com.wtw.championship.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User user = userRepository.getById(userId);
        Role role = roleRepository.getById(roleId);
        if(user.getUser_id()==null) {
            throw new Exception ("User + " + userId + " could not be found.");
        }
        if(role.getRole_id()==null) {
            throw new Exception ("Role + " + roleId + " could not be found.");
        }
        Role existingRole = user.containsRole(role);
        if(existingRole==null){
            user.addRole(role);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getUsersByRole(Long roleId) {
        List<User> users = userRepository.findByRoleId(roleId);
        return users;
    }

    @Override
    public User addUser(User user) throws Exception {
        return userRepository.save(user);
    }

}
