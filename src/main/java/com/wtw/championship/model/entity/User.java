package com.wtw.championship.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long user_id;

    @Column
    private String steam_name;

    @Column
    private String password;

    @Column
    private String steam_url;

    @Column
    private Date start_date;

    @Column
    private Boolean active;

    @Column
    private Date last_modification;

    @JsonIgnore
    @ManyToMany
    @JoinTable (
            name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private List<Role> userRoles = new ArrayList<>();

    public void addRole(Role role) {
        userRoles.add(role);
    }

    public Role containsRole(Role role) {
        for (Role rol: userRoles) {
            if(rol.getRole_id().equals(role.getRole_id())){
                return rol;
            }
        }
        return null;
    }

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Checkin> checkins;

}