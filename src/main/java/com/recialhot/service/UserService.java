package com.recialhot.service;

import com.recialhot.domain.LoginTicket;
import com.recialhot.domain.User;

import java.util.Map;

public interface UserService {
    User findUserById(int id);
    Map<String,Object> register(User user);

    Map<String,Object> login(String username,String password,int expiredSeconds);

    void logout(String ticket);

    LoginTicket findLoginTicket(String ticket);

    int updateHeader(int userId,String headerUrl);

    User findUserByName(String toName);
}
