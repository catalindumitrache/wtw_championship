package com.wtw.championship.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/roles")
public class RoleController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

}
