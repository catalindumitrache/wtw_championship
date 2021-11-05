package com.wtw.championship.service;

import com.wtw.championship.model.entity.Checkin;
import com.wtw.championship.model.entity.User;

import java.text.ParseException;
import java.util.List;

public interface ICheckinService {
    List<Checkin> getCheckinListByDate(String date) throws ParseException;
    List<Checkin> getCheckinList();
    Checkin addUserCheckin(Long userId, Checkin checkin);
}
