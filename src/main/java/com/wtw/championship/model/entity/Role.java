package com.wtw.championship.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long role_id;

    @Column
    private String name;

    @Column
    private boolean active;

    @JsonIgnore
    @ManyToMany(mappedBy = "userRoles")
    private List<User> users;

    public Role(String name, Boolean active, List<User> users) {
        this.name = name;
        this.active = active;
        this.users = users;
    }

    public Role() {

    }
}