package com.wtw.championship.service.impl;

import com.wtw.championship.model.dto.GenericResponseDTO;
import com.wtw.championship.model.dto.UserRequestDto;
import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.model.repository.IRoleRepository;
import com.wtw.championship.model.repository.IUserRepository;
import com.wtw.championship.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole (Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


}
