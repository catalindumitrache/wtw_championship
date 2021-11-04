package com.wtw.championship.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController (IUserService userService) {
        this.userService = userService;
    }

	@GetMapping
	public List<User> getUsers() {
        return userService.getAllUsers();
	}

    @PostMapping
    public User addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @PostMapping(value = "/{userId}/roles/{roleId}")
    public void mapRoleToUser(@PathVariable Long userId, @PathVariable Long roleId) throws Exception {
        userService.mapRoleToUser(roleId, userId);
    }

    @GetMapping(value = "/roles/{roleId}")
    public List<User> getUsersByRole(@PathVariable Long roleId) throws Exception {
        return userService.getUsersByRole(roleId);
    }

}
