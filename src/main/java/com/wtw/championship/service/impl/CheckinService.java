package com.wtw.championship.service.impl;

import com.wtw.championship.model.entity.Checkin;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.model.repository.ICheckinRepository;
import com.wtw.championship.model.repository.IUserRepository;
import com.wtw.championship.service.ICheckinService;
import com.wtw.championship.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CheckinService implements ICheckinService {

    private ICheckinRepository checkinRepository;

    @Autowired
    public CheckinService(ICheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    public List<Checkin> getCheckinListByDate(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Checkin> checkins = checkinRepository.findAllByDate(date1);
        return checkins;
    }
    public List<Checkin> getCheckinList() {
        return checkinRepository.findAll();
    }

}
