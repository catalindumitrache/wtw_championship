package com.wtw.championship.model.dto;

import com.wtw.championship.model.entity.Role;

import java.util.Date;
import java.util.List;

public class UserRequestDto {
    private Long user_id;
    private String steam_name;
    private String password;
    private String steam_url;
    private Date start_date;
    private Boolean active;
    private Date last_modification;
    private List<String> roles;
}
