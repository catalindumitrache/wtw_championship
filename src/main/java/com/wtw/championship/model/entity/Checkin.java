package com.wtw.championship.model.entity;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @Column
    private Long user_id;

    @Column
    private Date date;

    @Column
    private Boolean will_attend;

}