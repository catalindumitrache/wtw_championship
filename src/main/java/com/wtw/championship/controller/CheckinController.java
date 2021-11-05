package com.wtw.championship.controller;

import com.wtw.championship.model.entity.Checkin;
import com.wtw.championship.model.entity.Role;
import com.wtw.championship.model.entity.User;
import com.wtw.championship.service.ICheckinService;
import com.wtw.championship.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path="/checkin")
public class CheckinController {

    private final ICheckinService checkinService;

    @Autowired
    public CheckinController(ICheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @GetMapping
    public List<Checkin> getCheckinList() {
        return checkinService.getCheckinList();
    }

	@GetMapping(value = "/byDate")
	public List<Checkin> getCheckinListByDate(@RequestParam("date") String date) {
        try {
            return checkinService.getCheckinListByDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public Checkin addUserCheckin(
            @RequestParam(value="userId", required=true) Long userId,
            @RequestBody Checkin checkin) throws Exception {
        return checkinService.addUserCheckin(userId, checkin);
    }

}
