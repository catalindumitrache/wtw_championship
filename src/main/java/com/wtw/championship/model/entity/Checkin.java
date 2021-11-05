package com.wtw.championship.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="CHECKIN")
public class Checkin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long checkin_id;

    @ManyToOne
    private User user;

    @Column
    private Date date;

    @Column
    private Boolean will_attend;

}