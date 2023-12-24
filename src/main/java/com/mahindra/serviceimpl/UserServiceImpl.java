package com.mahindra.serviceimpl;

import com.mahindra.dao.UserRepo;
import com.mahindra.entity.User;
import com.mahindra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User saveUser(User user) {

        if(!userRepo.existsById(user.getLeadId()))
            return userRepo.save(user);
        return null;
    }

    @Override
    public List<User> findByMobNo(String no) {
        return userRepo.findBymobileNumber(no);
    }
}
