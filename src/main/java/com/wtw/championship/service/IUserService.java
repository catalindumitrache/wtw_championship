package com.wtw.championship.service;

import com.wtw.championship.model.dto.GenericResponseDTO;
import com.wtw.championship.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User addUser(User user) throws Exception;
    void mapRoleToUser(Long roleId, Long userId) throws Exception;
    List<User> getUsersByRole(Long roleId);
}
