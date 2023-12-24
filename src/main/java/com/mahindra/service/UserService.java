package com.mahindra.service;

import com.mahindra.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    List<User> findByMobNo(String no);
}
