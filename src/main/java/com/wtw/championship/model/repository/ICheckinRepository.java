package com.wtw.championship.model.repository;


import com.wtw.championship.model.entity.Checkin;
import com.wtw.championship.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICheckinRepository extends JpaRepository<Checkin, Long> {

    List<Checkin> findAllByDate(Date date);
}