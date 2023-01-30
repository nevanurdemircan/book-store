package com.example.sahaf.service;

import com.example.sahaf.dto.UsersPageDto;
import com.example.sahaf.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> findAll();

    User updateUser(User user);

    Boolean delete(int id);

    User findById(int id);
    UsersPageDto getUsersList(int no, int size);
}
