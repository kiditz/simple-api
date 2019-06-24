package com.homecredit.test.service;

import com.homecredit.test.entity.User;
import com.homecredit.test.entity.model.Modules;

import java.util.List;

public interface UserService {


    List<User> saveAllUser(List<User> user);

    Modules getModules(int userId);

    void deleteAll();
}
