package com.wtw.championship.service.impl;

import com.wtw.championship.model.entity.Checkin;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.model.repository.ICheckinRepository;
import com.wtw.championship.model.repository.IUserRepository;
import com.wtw.championship.service.ICheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckinService implements ICheckinService {

    private ICheckinRepository checkinRepository;
    private IUserRepository userRepository;

    @Autowired
    public CheckinService(ICheckinRepository checkinRepository,
            IUserRepository userRepository) {
        this.checkinRepository = checkinRepository;
        this.userRepository = userRepository;
    }

    public List<Checkin> getCheckinListByDate(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Checkin> checkins = checkinRepository.findAllByDate(date1);
        return checkins;
    }
    public List<Checkin> getCheckinList() {
        return checkinRepository.findAll();
    }

    @Override
    public Checkin addUserCheckin(Long userId, Checkin checkin) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            checkin.setUser(user.get());
            return checkinRepository.save(checkin);
        }
        return null;
    }

}
