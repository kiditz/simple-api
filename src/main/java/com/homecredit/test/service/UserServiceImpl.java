package com.homecredit.test.service;

import com.homecredit.test.entity.Module;
import com.homecredit.test.entity.User;
import com.homecredit.test.entity.model.Modules;
import com.homecredit.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author kiditz 26/06/2019
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> saveAllUser(List<User> user) {
        return userRepository.saveAll(user);
    }

    @Override
    public Modules getModules(int userId) {
        List<Module> modules = userRepository.findById(userId).orElse(new User()).getModules();
        return new Modules(modules);
    }

    @Transactional
    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
