package com.wtw.championship.service;

import com.wtw.championship.model.dto.GenericResponseDTO;
import com.wtw.championship.model.dto.UserRequestDto;
import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;

import java.util.List;

public interface IRoleService {
    Role addRole (Role role);

    List<Role> getAllRoles();
}
